package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class TenantsOperations {
  private final AxHubClient c;
  TenantsOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> tenantsGetApiV1Tenants(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1Tenants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1Tenants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetApiV1TenantsByTenantID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetApiV1TenantsByTenantIDMembersDirectory(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantIDMembersDirectory", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDMembersDirectoryAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantIDMembersDirectory", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetApiV1TenantsByTenantIDOrgDirectory(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantIDOrgDirectory", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDOrgDirectoryAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantIDOrgDirectory", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
