package ai.axhub.sdk;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class AllOperationsE2ETest {
  private static final Pattern PATH_PARAM_PATTERN = Pattern.compile("\\{([^}]+)\\}");

  static void run() throws Exception {
    require(Routes.ALL.size() == 228, "route coverage drift " + Routes.ALL.size());
    AtomicInteger expectedIndex = new AtomicInteger();
    HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext("/", exchange -> {
      int index = expectedIndex.getAndIncrement();
      require(index < Routes.ALL.size(), "unexpected extra request " + exchange.getRequestMethod() + " " + exchange.getRequestURI());
      Route route = Routes.ALL.get(index);
      Map<String, String> params = pathParamsFor(route.path());
      String wantPath = renderPath(route.path(), params);
      require(route.method().equals(exchange.getRequestMethod()), route.operationId() + " method " + exchange.getRequestMethod() + " != " + route.method());
      require(wantPath.equals(exchange.getRequestURI().getPath()), route.operationId() + " path " + exchange.getRequestURI().getPath() + " != " + wantPath);
      require(exchange.getRequestURI().getQuery() != null && exchange.getRequestURI().getQuery().contains("e2e=ok"), route.operationId() + " missing e2e query");
      require("pat_e2e".equals(exchange.getRequestHeaders().getFirst("X-Api-Key")), route.operationId() + " missing PAT header");
      require(exchange.getRequestHeaders().getFirst("X-Request-ID") != null && !exchange.getRequestHeaders().getFirst("X-Request-ID").isBlank(), route.operationId() + " missing request id");
      byte[] body = ("{\"operation_id\":\"" + route.operationId() + "\",\"ok\":true}").getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "application/json");
      exchange.sendResponseHeaders(200, body.length);
      try (OutputStream os = exchange.getResponseBody()) { os.write(body); }
    });
    server.start();
    try {
      AxHubClient client = AxHubClient.builder().baseUrl("http://127.0.0.1:" + server.getAddress().getPort()).token("pat_e2e").tokenType(TokenType.PAT).build();
      Map<String, Object> contexts = Map.of(
        "apps", client.appsRoutes(), "identity", client.identity(), "tenants", client.tenants(), "authz", client.authz(),
        "audit", client.audit(), "gateway", client.gateway(), "cost", client.cost(), "data", client.data(), "deployments", client.deployments()
      );
      for (Route route : Routes.ALL) {
        Object context = contexts.get(ContextRoutes.contextName(route));
        Method method = context.getClass().getMethod(route.operationId(), Map.class, Map.class, Object.class);
        @SuppressWarnings("unchecked")
        Map<String, Object> got = (Map<String, Object>) method.invoke(context, pathParamsFor(route.path()), Map.of("e2e", "ok"), bodyFor(route));
        require(route.operationId().equals(got.get("operationId")), route.operationId() + " response was not parsed/camelized: " + got);
      }
      require(expectedIndex.get() == Routes.ALL.size(), "expected " + Routes.ALL.size() + " HTTP requests, saw " + expectedIndex.get());
    } finally {
      server.stop(0);
    }
  }

  private static Map<String, String> pathParamsFor(String path) {
    Map<String, String> params = new HashMap<>();
    Matcher matcher = PATH_PARAM_PATTERN.matcher(path);
    while (matcher.find()) params.put(matcher.group(1), pathParamValue(matcher.group(1)));
    return params;
  }

  private static String pathParamValue(String name) {
    return switch (name) {
      case "tenantID" -> "tnt_1";
      case "tenantSlug" -> "test-tenant";
      case "appID" -> "app_1";
      case "appSlug" -> "app-slug";
      case "table", "tableName" -> "table_1";
      case "path" -> "resource-path";
      case "domain" -> "example.com";
      default -> name.toLowerCase() + "_1";
    };
  }

  private static String renderPath(String path, Map<String, String> params) {
    Matcher matcher = PATH_PARAM_PATTERN.matcher(path);
    StringBuffer out = new StringBuffer();
    while (matcher.find()) matcher.appendReplacement(out, Matcher.quoteReplacement(encode(params.get(matcher.group(1)))));
    matcher.appendTail(out);
    return out.toString();
  }

  private static String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }

  private static Object bodyFor(Route route) {
    if ("GET".equals(route.method()) || "DELETE".equals(route.method())) return null;
    return Map.of("operationId", route.operationId(), "ok", true);
  }

  private static void require(boolean ok, String message) {
    if (!ok) throw new AssertionError(message);
  }
}
