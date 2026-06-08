package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class CostOperations {
  private final AxHubClient c;
  CostOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> costGetApiV1TenantsByTenantIDCostByApp(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("costGetApiV1TenantsByTenantIDCostByApp", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> costGetApiV1TenantsByTenantIDCostByAppAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("costGetApiV1TenantsByTenantIDCostByApp", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> costGetApiV1TenantsByTenantIDCostByCostCenter(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("costGetApiV1TenantsByTenantIDCostByCostCenter", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> costGetApiV1TenantsByTenantIDCostByCostCenterAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("costGetApiV1TenantsByTenantIDCostByCostCenter", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> costGetApiV1TenantsByTenantIDCostExport(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("costGetApiV1TenantsByTenantIDCostExport", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> costGetApiV1TenantsByTenantIDCostExportAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("costGetApiV1TenantsByTenantIDCostExport", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> costGetApiV1TenantsByTenantIDCostSummary(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("costGetApiV1TenantsByTenantIDCostSummary", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> costGetApiV1TenantsByTenantIDCostSummaryAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("costGetApiV1TenantsByTenantIDCostSummary", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> costGetApiV1TenantsByTenantIDCostTimeseries(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("costGetApiV1TenantsByTenantIDCostTimeseries", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> costGetApiV1TenantsByTenantIDCostTimeseriesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("costGetApiV1TenantsByTenantIDCostTimeseries", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
