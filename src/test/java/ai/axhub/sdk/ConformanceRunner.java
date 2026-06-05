package ai.axhub.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class ConformanceRunner {
  private static final Gson GSON = new Gson();
  private static final Type MAP_STRING_OBJECT = new TypeToken<Map<String, Object>>() {}.getType();
  private static final Type MAP_STRING_STRING = new TypeToken<Map<String, String>>() {}.getType();

  static void run() throws Exception {
    List<Path> files = Files.list(vectorDir()).filter(p -> p.toString().endsWith(".json")).sorted(Comparator.comparing(Path::toString)).toList();
    RegressionTest.require(!files.isEmpty(), "no conformance vectors");
    for (Path file : files) runOne(file, GSON.fromJson(Files.readString(file), Vector.class));
  }

  private static Path vectorDir() {
    String explicit = System.getenv("AXHUB_CONFORMANCE_DIR");
    if (explicit != null && !explicit.isBlank() && Files.isDirectory(Path.of(explicit))) return Path.of(explicit);
    Path repoLocal = Path.of("testdata", "conformance", "vectors");
    if (Files.isDirectory(repoLocal)) return repoLocal;
    Path local = Path.of("..", "conformance", "vectors");
    if (Files.isDirectory(local)) return local;
    return Path.of(System.getenv().getOrDefault("AXHUB_SPEC_DIR", "../../axhub-sdk-spec"), "conformance", "vectors");
  }

  private static void runOne(Path file, Vector v) throws Exception {
    Seen seen = new Seen();
    HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext("/", exchange -> {
      seen.method = exchange.getRequestMethod();
      seen.path = exchange.getRequestURI().getPath();
      exchange.getRequestHeaders().forEach((k, values) -> { if (!values.isEmpty()) seen.headers.put(k.toLowerCase(Locale.ROOT), values.get(0)); });
      MockResponse response = v.mockResponse == null ? new MockResponse() : v.mockResponse;
      int status = response.status == 0 ? 200 : response.status;
      String body = GSON.toJson(response.body == null ? Map.of() : response.body);
      byte[] raw = body.getBytes();
      exchange.sendResponseHeaders(status, raw.length);
      try (OutputStream os = exchange.getResponseBody()) { os.write(raw); }
    });
    server.start();
    try {
      AxHubClient c = AxHubClient.builder()
        .baseUrl("http://127.0.0.1:" + server.getAddress().getPort())
        .token(v.client == null ? null : v.client.token)
        .tokenType(v.client != null && "jwt".equals(v.client.tokenType) ? TokenType.JWT : TokenType.PAT)
        .defaultTenantId(v.client == null ? null : v.client.defaultTenantId)
        .build();
      Map<String, Object> got = null;
      AxHubException err = null;
      try { got = dispatch(c, v); } catch (AxHubException e) { err = e; }
      if (v.expect.error != null) {
        RegressionTest.require(err != null, file + " expected error");
        RegressionTest.require(v.expect.error.category.equals(err.category()) && v.expect.error.code.equals(err.code()), file + " wrong error " + err.category() + "/" + err.code());
        if (v.expect.error.requestId != null) RegressionTest.require(v.expect.error.requestId.equals(err.requestId()), file + " wrong request id " + err.requestId());
        if (v.expect.error.retryable != null) RegressionTest.require(v.expect.error.retryable == err.retryable(), file + " wrong retryable " + err.retryable());
      } else {
        RegressionTest.require(err == null, file + " unexpected error " + (err == null ? "" : err.code()));
        for (var e : v.expect.ok.entrySet()) RegressionTest.require(String.valueOf(e.getValue()).equals(String.valueOf(got.get(e.getKey()))), file + " " + e.getKey() + " drift " + got);
      }
      if (v.httpExpect != null) {
        RegressionTest.require(v.httpExpect.method.equals(seen.method) && v.httpExpect.path.equals(seen.path), file + " wrong request " + seen.method + " " + seen.path);
        for (String h : nullToEmpty(v.httpExpect.headersInclude)) RegressionTest.require(seen.headers.get(h.toLowerCase(Locale.ROOT)) != null, file + " missing header " + h);
        for (var e : nullToEmpty(v.httpExpect.headersExact).entrySet()) RegressionTest.require(e.getValue().equals(seen.headers.get(e.getKey().toLowerCase(Locale.ROOT))), file + " wrong header " + e.getKey());
      } else {
        RegressionTest.require(seen.method == null, file + " expected no request");
      }
    } finally { server.stop(0); }
  }

  private static Map<String, Object> dispatch(AxHubClient c, Vector v) {
    return switch (v.call.symbol) {
      case "sdk.apps.create" -> c.apps().create(v.call.args == null ? Map.of() : v.call.args);
      case "sdk.operation" -> c.request(v.call.operationId, v.call.pathParams == null ? Map.of() : v.call.pathParams, v.call.query == null ? Map.of() : v.call.query, v.call.body);
      case "sdk.redactedToken" -> Map.of("redactedToken", c.redactedToken());
      default -> throw new AxHubException("validation", "unknown_vector_symbol", v.call.symbol, 0, false);
    };
  }

  private static <T> List<T> nullToEmpty(List<T> v) { return v == null ? List.of() : v; }
  private static <K,V> Map<K,V> nullToEmpty(Map<K,V> v) { return v == null ? Map.of() : v; }

  static final class Seen { String method; String path; Map<String, String> headers = new LinkedHashMap<>(); }
  static final class Vector { ClientConfig client; Call call; HttpExpect httpExpect; MockResponse mockResponse; Expect expect; }
  static final class ClientConfig { String tokenType; String token; String defaultTenantId; }
  static final class Call { String symbol; String operationId; Map<String, Object> args; Map<String, String> pathParams; Map<String, String> query; JsonElement body; }
  static final class HttpExpect { String method; String path; List<String> headersInclude; Map<String, String> headersExact; }
  static final class MockResponse { int status; JsonElement body; }
  static final class Expect { Map<String, Object> ok; ErrorExpect error; }
  static final class ErrorExpect { String category; String code; String requestId; Boolean retryable; }
}
