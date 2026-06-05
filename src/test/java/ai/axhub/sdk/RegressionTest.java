package ai.axhub.sdk;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

public final class RegressionTest {
  public static void main(String[] args) throws Exception {
    testAppsCreateConformance();
    testTenantRequiredBeforeRequest();
    testErrorAndRouteCoverage();
    testNestedJsonAndErrorMetadata();
    testTokenRedaction();
    testEightContextCoverage();
    OperationsCoverageTest.run();
    AllOperationsE2ETest.run();
    ConformanceRunner.run();
  }
  static void testAppsCreateConformance() throws Exception {
    final String[] seen = new String[4];
    HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext("/", exchange -> {
      seen[0] = exchange.getRequestMethod(); seen[1] = exchange.getRequestURI().getPath();
      seen[2] = exchange.getRequestHeaders().getFirst("X-Api-Key"); seen[3] = exchange.getRequestHeaders().getFirst("X-Request-ID");
      byte[] body = "{\"id\":\"app_1\",\"tenant_id\":\"tnt_1\",\"slug\":\"my-app\",\"schema_name\":\"app_my-app\"}".getBytes();
      exchange.sendResponseHeaders(200, body.length); try (OutputStream os = exchange.getResponseBody()) { os.write(body); }
    });
    server.start();
    try {
      AxHubClient client = AxHubClient.builder().baseUrl("http://127.0.0.1:" + server.getAddress().getPort()).token("pat_x").tokenType(TokenType.PAT).defaultTenantId("tnt_1").build();
      Map<String,Object> got = client.apps().create(Map.of("slug", "my-app", "name", "My App"));
      require("app_1".equals(got.get("id")), "unexpected id " + got);
      require("app_my-app".equals(got.get("schemaName")), "camelized schemaName missing " + got);
      require("POST".equals(seen[0]) && "/api/v1/tenants/tnt_1/apps".equals(seen[1]), "wrong request");
      require("pat_x".equals(seen[2]), "missing api key");
      require(seen[3] != null && !seen[3].isBlank(), "missing request id");
    } finally { server.stop(0); }
  }
  static void testTenantRequiredBeforeRequest() {
    AxHubClient client = AxHubClient.builder().baseUrl("http://127.0.0.1:1").token("pat_x").tokenType(TokenType.PAT).build();
    try { client.apps().create(Map.of("slug", "my-app")); throw new AssertionError("expected AxHubException"); }
    catch (AxHubException e) { require("tenant_id_required".equals(e.category()) && "tenant_id_required".equals(e.code()), "wrong error " + e); }
  }
  static void testErrorAndRouteCoverage() {
    require(Routes.ALL.size() == 177, "route coverage drift " + Routes.ALL.size());
    require(ErrorCodes.ALL.size() == 42, "error code drift " + ErrorCodes.ALL.size());
    require("conflict".equals(ErrorCodes.ALL.get("slug_taken").category()), "slug_taken category drift");
  }
  static void testNestedJsonAndErrorMetadata() throws Exception {
    final String[] bodySeen = new String[1];
    HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext("/", exchange -> {
      bodySeen[0] = new String(exchange.getRequestBody().readAllBytes());
      String rawPath = exchange.getRequestURI().getPath();
      byte[] body;
      if (rawPath.contains("error")) {
        body = "{\"error\":{\"category\":\"unauthenticated\",\"code\":\"token_expired\",\"message\":\"expired\",\"request_id\":\"req_java\"}}".getBytes();
        exchange.sendResponseHeaders(401, body.length);
      } else {
        body = "{\"id\":\"app_nested\",\"tenant_id\":\"tnt_1\",\"slug\":\"nested\",\"schema_name\":\"app_nested\",\"metadata\":{\"inner_value\":\"ok\"},\"items\":[{\"child_value\":\"ok\"}]}".getBytes();
        exchange.sendResponseHeaders(200, body.length);
      }
      try (OutputStream os = exchange.getResponseBody()) { os.write(body); }
    });
    server.start();
    try {
      AxHubClient client = AxHubClient.builder().baseUrl("http://127.0.0.1:" + server.getAddress().getPort()).token("pat_x").tokenType(TokenType.PAT).defaultTenantId("tnt_1").build();
      Map<String,Object> got = client.apps().create(Map.of("slug", "nested", "name", "Nested", "metadata", Map.of("inner_value", "ok"), "items", List.of(Map.of("child_value", "ok"))));
      require(bodySeen[0].contains("metadata") && bodySeen[0].contains("items"), "nested request was not encoded: " + bodySeen[0]);
      require(((Map<?,?>) got.get("metadata")).get("innerValue").equals("ok"), "nested response was not camelized: " + got);
      require(((Map<?,?>) ((List<?>) got.get("items")).get(0)).get("childValue").equals("ok"), "array response was not camelized: " + got);
      try { client.request("appsGetApiV1AppsByAppID", Map.of("appID", "error"), Map.of(), null); throw new AssertionError("expected error"); }
      catch (AxHubException e) { require("req_java".equals(e.requestId()) && e.retryable(), "error metadata drift: " + e.requestId() + " retry=" + e.retryable()); }
    } finally { server.stop(0); }
  }

  static void testTokenRedaction() {
    AxHubClient client = AxHubClient.builder().baseUrl("http://127.0.0.1:1").token("pat_secret").tokenType(TokenType.PAT).build();
    require("***REDACTED***".equals(client.redactedToken()), "token prefix leaked: " + client.redactedToken());
  }

  static void testEightContextCoverage() {
    for (String name : ContextRoutes.NAMES) require(!ContextRoutes.ALL.get(name).isEmpty(), "missing context routes " + name);
  }

  static void require(boolean ok, String message) { if (!ok) throw new AssertionError(message); }
}
