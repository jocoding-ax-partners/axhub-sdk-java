package ai.axhub.sdk.example;

import ai.axhub.sdk.*;
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;

public final class App {
  public static void main(String[] args) throws Exception {
    String token = System.getenv("AXHUB_TOKEN");
    if (token != null && !token.isBlank()) {
      runProd(token);
      return;
    }
    runLocal();
  }

  private static void runProd(String token) {
    String baseUrl = envOr("AXHUB_BASE_URL", "https://api.axhub.ai");
    AxHubClient c = AxHubClient.builder()
        .baseUrl(baseUrl)
        .token(token)
        .tokenType(TokenType.valueOf(envOr("AXHUB_TOKEN_TYPE", "").toUpperCase()))
        .defaultTenantId(System.getenv("AXHUB_TENANT_ID"))
        .build();
    Map<String, Object> got = c.identity().authGetApiV1Me(Map.of(), Map.of(), null);
    System.out.println("java prod test app ok " + c.baseUrl() + " keys=" + got.size());
  }

  private static void runLocal() throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext("/", ex -> {
      byte[] body = "{\"id\":\"app_demo\",\"tenant_id\":\"tnt_demo\",\"slug\":\"demo\",\"schema_name\":\"app_demo\"}".getBytes();
      ex.sendResponseHeaders(200, body.length);
      try (OutputStream os = ex.getResponseBody()) { os.write(body); }
    });
    server.start();
    try {
      AxHubClient c = AxHubClient.builder().baseUrl("http://127.0.0.1:" + server.getAddress().getPort()).token("pat_demo").tokenType(TokenType.PAT).defaultTenantId("tnt_demo").build();
      Map<String, Object> got = c.apps().create(Map.of("slug", "demo", "name", "Demo"));
      System.out.println("java test app ok " + got.get("id"));
    } finally {
      server.stop(0);
    }
  }

  private static String envOr(String key, String fallback) {
    String value = System.getenv(key);
    return value == null || value.isBlank() ? fallback : value;
  }
}
