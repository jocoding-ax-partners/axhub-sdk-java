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
  public Map<String, Object> costGetApiV1TenantsByTenantIDCostMonths(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("costGetApiV1TenantsByTenantIDCostMonths", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> costGetApiV1TenantsByTenantIDCostMonthsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("costGetApiV1TenantsByTenantIDCostMonths", RouteOperations.map(pathParams), RouteOperations.map(query), body);
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
  public Map<String, Object> costGetApiV1TenantsByTenantIDInfraAppsByAppIDUsageSeries(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("costGetApiV1TenantsByTenantIDInfraAppsByAppIDUsageSeries", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> costGetApiV1TenantsByTenantIDInfraAppsByAppIDUsageSeriesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("costGetApiV1TenantsByTenantIDInfraAppsByAppIDUsageSeries", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> costGetApiV1TenantsByTenantIDInfraUsage(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("costGetApiV1TenantsByTenantIDInfraUsage", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> costGetApiV1TenantsByTenantIDInfraUsageAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("costGetApiV1TenantsByTenantIDInfraUsage", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
