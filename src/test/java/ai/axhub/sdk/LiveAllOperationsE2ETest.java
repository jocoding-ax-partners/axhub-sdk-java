package ai.axhub.sdk;

import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class LiveAllOperationsE2ETest {
  private static final Gson GSON = new Gson();
  private static final Pattern PATH_PARAM_PATTERN = Pattern.compile("\\{([^}]+)\\}");
  private static final String DEAD_UUID = "00000000-0000-4000-8000-00000000dead";
  private static final Map<String, Boolean> HIGH_RISK_TENANT_OPS = Map.of(
      "tenantsDeleteApiV1TenantsByTenantID", true,
      "tenantsPatchApiV1TenantsByTenantID", true,
      "tenantsDeleteApiV1TenantsByTenantIDIcon", true,
      "gatewayGetApiV1TenantsByTenantIDConnectorsByConnectorIDDiscover", true,
      "gatewayPostApiV1TenantsByTenantIDConnectors", true
  );
  private static final Map<String, Boolean> HIGH_RISK_APP_OPS = Map.of(
      "appsDeleteApiV1AppsByAppID", true,
      "appsDeleteApiV1AppsByAppIDPermanent", true,
      "deployPostApiV1AppsByAppIDDeploymentsByDidCancel", true,
      "deployPostApiV1AppsByAppIDDeploymentsByDidRollback", true
  );

  static void run() throws Exception {
    String token = requireEnv("AXHUB_TOKEN");
    String tenantId = getenv("AXHUB_LIVE_TENANT_ID", "cc1e58f1-8e46-4ac7-96c1-190c4cdd5b70");
    String tenantSlug = getenv("AXHUB_LIVE_TENANT_SLUG", "test");
    String baseUrl = getenv("AXHUB_LIVE_BASE_URL", "https://api.axhub.ai");
    require(Routes.ALL.size() == 86, "route coverage drift " + Routes.ALL.size());
    AxHubClient client = AxHubClient.builder().baseUrl(baseUrl).token(token).tokenType(TokenType.PAT).defaultTenantId(tenantId).build();
    Map<String, String> fixture = new HashMap<>();
    boolean createdFixture = false;
    try {
      Map<String, Object> created = client.apps().create(Map.of("slug", "sdk-e2e-destructive-java-" + Instant.now().toEpochMilli(), "name", "SDK destructive E2E disposable"));
      if (created.get("id") instanceof String id && !id.isBlank()) {
        fixture.put("appID", id);
        createdFixture = true;
      }
      if (created.get("slug") instanceof String slug) fixture.put("appSlug", slug);
    } catch (AxHubException ignored) {
      // Dead app id fallback still exercises every generated method without mutating real data.
    }

    List<Map<String, Object>> results = new ArrayList<>();
    try {
      Map<String, Object> contexts = Map.of(
          "apps", client.appsRoutes(), "identity", client.identity(), "tenants", client.tenants(), "authz", client.authz(),
          "audit", client.audit(), "gateway", client.gateway(), "data", client.data(), "deployments", client.deployments()
      );
      for (Route route : Routes.ALL) {
        Map<String, Object> result = new HashMap<>();
        result.put("operationId", route.operationId());
        result.put("method", route.method());
        result.put("kind", "unknown");
        try {
          Object context = contexts.get(ContextRoutes.contextName(route));
          Method method = context.getClass().getMethod(route.operationId(), Map.class, Map.class, Object.class);
          method.invoke(context, pathParamsFor(route, fixture, tenantId, tenantSlug), Map.of("sdk_e2e", "live_all_methods"), bodyFor(route));
          result.put("kind", "success");
        } catch (InvocationTargetException e) {
          Throwable cause = e.getCause();
          if (cause instanceof AxHubException ax) {
            result.put("kind", "axhub_error");
            result.put("status", ax.status());
            result.put("code", ax.code());
            result.put("category", ax.category());
            result.put("server_error", ax.status() >= 500);
          } else {
            result.put("kind", "exception");
            result.put("exception", cause.getClass().getName());
            result.put("error", cause.getMessage());
          }
        } catch (Throwable e) {
          result.put("kind", "exception");
          result.put("exception", e.getClass().getName());
          result.put("error", e.getMessage());
        }
        results.add(result);
      }
    } finally {
      if (createdFixture && fixture.get("appID") != null) {
        for (String operationId : List.of("appsDeleteApiV1AppsByAppID", "appsDeleteApiV1AppsByAppIDPermanent")) {
          try { client.request(operationId, Map.of("appID", fixture.get("appID")), Map.of(), null); } catch (AxHubException ignored) {}
        }
      }
    }

    Map<String, Object> summary = new HashMap<>();
    summary.put("sdk", "java");
    summary.put("baseUrl", baseUrl);
    summary.put("tenantId", tenantId);
    summary.put("fixture", Map.of("created", createdFixture, "appID", fixture.getOrDefault("appID", ""), "appSlug", fixture.getOrDefault("appSlug", "")));
    summary.put("total", results.size());
    summary.put("destructive", count(results, r -> !"GET".equals(r.get("method"))));
    summary.put("success", count(results, r -> "success".equals(r.get("kind"))));
    summary.put("axhub_error", count(results, r -> "axhub_error".equals(r.get("kind"))));
    summary.put("exception", count(results, r -> "exception".equals(r.get("kind"))));
    summary.put("server_errors", filter(results, r -> Boolean.TRUE.equals(r.get("server_error"))));
    summary.put("exceptions", filter(results, r -> "exception".equals(r.get("kind"))));
    summary.put("results", results);
    if (System.getenv("AXHUB_LIVE_RESULT_PATH") != null) writeResult(System.getenv("AXHUB_LIVE_RESULT_PATH"), summary);
    require(results.size() == 86, "total drift " + results.size());
    int expectedDestructive = 0;
    for (Route route : Routes.ALL) if (!"GET".equals(route.method())) expectedDestructive++;
    require((int) summary.get("destructive") == expectedDestructive, "destructive method count drift " + summary.get("destructive") + " != " + expectedDestructive);
    require(((List<?>) summary.get("exceptions")).isEmpty(), "exceptions " + summary.get("exceptions"));
    require(((List<?>) summary.get("server_errors")).isEmpty(), "server errors " + summary.get("server_errors"));
  }

  private static Map<String, String> pathParamsFor(Route route, Map<String, String> fixture, String tenantId, String tenantSlug) {
    Map<String, String> params = new HashMap<>();
    Matcher matcher = PATH_PARAM_PATTERN.matcher(route.path());
    while (matcher.find()) params.put(matcher.group(1), pathParamValue(matcher.group(1), route.operationId(), fixture, tenantId, tenantSlug));
    return params;
  }

  private static String pathParamValue(String name, String operationId, Map<String, String> fixture, String tenantId, String tenantSlug) {
    return switch (name) {
      case "tenantID" -> HIGH_RISK_TENANT_OPS.containsKey(operationId) ? DEAD_UUID : tenantId;
      case "tenantSlug" -> tenantSlug;
      case "appID" -> HIGH_RISK_APP_OPS.containsKey(operationId) ? DEAD_UUID : fixture.getOrDefault("appID", DEAD_UUID);
      case "appSlug" -> fixture.getOrDefault("appSlug", "sdk-e2e-missing-app");
      case "table", "tableName" -> "sdk_e2e_missing_table";
      case "path" -> "sdk/e2e/missing";
      case "domain" -> "sdk-e2e.invalid";
      case "providerID" -> "authGetAuthByProviderIDStart".equals(operationId) ? "github" : "sdk-e2e-provider";
      case "patID" -> DEAD_UUID;
      case "key" -> "SDK_E2E_NOOP";
      case "connector" -> "sdk-e2e-connector";
      default -> DEAD_UUID;
    };
  }

  private static Object bodyFor(Route route) {
    if ("GET".equals(route.method()) || "DELETE".equals(route.method())) return null;
    return Map.of("sdk_e2e", true, "operation_id", route.operationId());
  }

  private interface ResultPredicate { boolean test(Map<String, Object> result); }

  private static int count(List<Map<String, Object>> results, ResultPredicate predicate) {
    int count = 0;
    for (Map<String, Object> result : results) if (predicate.test(result)) count++;
    return count;
  }

  private static List<Map<String, Object>> filter(List<Map<String, Object>> results, ResultPredicate predicate) {
    List<Map<String, Object>> out = new ArrayList<>();
    for (Map<String, Object> result : results) if (predicate.test(result)) out.add(result);
    return out;
  }

  private static String getenv(String key, String fallback) {
    String value = System.getenv(key);
    return value == null || value.isBlank() ? fallback : value;
  }

  private static String requireEnv(String key) {
    String value = System.getenv(key);
    if (value == null || value.isBlank()) throw new IllegalStateException(key + " is required");
    return value;
  }

  private static void writeResult(String path, Map<String, Object> summary) throws IOException {
    Files.writeString(Path.of(path), GSON.toJson(summary));
  }

  private static void require(boolean ok, String message) {
    if (!ok) throw new AssertionError(message);
  }
}
