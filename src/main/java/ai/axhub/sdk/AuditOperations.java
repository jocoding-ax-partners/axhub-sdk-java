package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class AuditOperations {
  private final AxHubClient c;
  AuditOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> auditGetApiV1TenantsByTenantIDAuditEvents(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("auditGetApiV1TenantsByTenantIDAuditEvents", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> auditGetApiV1TenantsByTenantIDAuditEventsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("auditGetApiV1TenantsByTenantIDAuditEvents", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> auditGetApiV1TenantsByTenantIDAuditEventsByEventID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("auditGetApiV1TenantsByTenantIDAuditEventsByEventID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> auditGetApiV1TenantsByTenantIDAuditEventsByEventIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("auditGetApiV1TenantsByTenantIDAuditEventsByEventID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> auditPostApiV1TenantsByTenantIDAuditEventsAnonymize(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("auditPostApiV1TenantsByTenantIDAuditEventsAnonymize", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> auditPostApiV1TenantsByTenantIDAuditEventsAnonymizeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("auditPostApiV1TenantsByTenantIDAuditEventsAnonymize", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> auditGetApiV1TenantsByTenantIDAuditEventsIntegrityCheck(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("auditGetApiV1TenantsByTenantIDAuditEventsIntegrityCheck", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> auditGetApiV1TenantsByTenantIDAuditEventsIntegrityCheckAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("auditGetApiV1TenantsByTenantIDAuditEventsIntegrityCheck", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
