package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class AuthzOperations {
  private final AxHubClient c;
  AuthzOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> authorizationGetApiV1TenantsByTenantIDMeGrants(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationGetApiV1TenantsByTenantIDMeGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationGetApiV1TenantsByTenantIDMeGrantsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationGetApiV1TenantsByTenantIDMeGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
