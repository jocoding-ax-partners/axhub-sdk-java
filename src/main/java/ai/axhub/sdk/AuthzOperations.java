package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class AuthzOperations {
  private final AxHubClient c;
  AuthzOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> authorizationGetApiV1TenantsByTenantIDGrants(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationGetApiV1TenantsByTenantIDGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationGetApiV1TenantsByTenantIDGrantsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationGetApiV1TenantsByTenantIDGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPostApiV1TenantsByTenantIDGrants(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPostApiV1TenantsByTenantIDGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPostApiV1TenantsByTenantIDGrantsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPostApiV1TenantsByTenantIDGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationDeleteApiV1TenantsByTenantIDGrantsByGrantID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationDeleteApiV1TenantsByTenantIDGrantsByGrantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationDeleteApiV1TenantsByTenantIDGrantsByGrantIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationDeleteApiV1TenantsByTenantIDGrantsByGrantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationGetApiV1TenantsByTenantIDGrantsByGrantID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationGetApiV1TenantsByTenantIDGrantsByGrantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationGetApiV1TenantsByTenantIDGrantsByGrantIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationGetApiV1TenantsByTenantIDGrantsByGrantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationGetApiV1TenantsByTenantIDMeGrants(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationGetApiV1TenantsByTenantIDMeGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationGetApiV1TenantsByTenantIDMeGrantsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationGetApiV1TenantsByTenantIDMeGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationGetApiV1TenantsByTenantIDPresets(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationGetApiV1TenantsByTenantIDPresets", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationGetApiV1TenantsByTenantIDPresetsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationGetApiV1TenantsByTenantIDPresets", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPostApiV1TenantsByTenantIDPresets(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPostApiV1TenantsByTenantIDPresets", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPostApiV1TenantsByTenantIDPresetsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPostApiV1TenantsByTenantIDPresets", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationDeleteApiV1TenantsByTenantIDPresetsByPresetID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationDeleteApiV1TenantsByTenantIDPresetsByPresetID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationDeleteApiV1TenantsByTenantIDPresetsByPresetIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationDeleteApiV1TenantsByTenantIDPresetsByPresetID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationGetApiV1TenantsByTenantIDPresetsByPresetID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationGetApiV1TenantsByTenantIDPresetsByPresetID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationGetApiV1TenantsByTenantIDPresetsByPresetIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationGetApiV1TenantsByTenantIDPresetsByPresetID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPatchApiV1TenantsByTenantIDPresetsByPresetID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPatchApiV1TenantsByTenantIDPresetsByPresetID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPatchApiV1TenantsByTenantIDPresetsByPresetIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPatchApiV1TenantsByTenantIDPresetsByPresetID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationGetApiV1TenantsByTenantIDSubjects(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationGetApiV1TenantsByTenantIDSubjects", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationGetApiV1TenantsByTenantIDSubjectsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationGetApiV1TenantsByTenantIDSubjects", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPostApiV1TenantsByTenantIDSubjects(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPostApiV1TenantsByTenantIDSubjects", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPostApiV1TenantsByTenantIDSubjectsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPostApiV1TenantsByTenantIDSubjects", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationGetApiV1TenantsByTenantIDSubjectsBySubjectID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationGetApiV1TenantsByTenantIDSubjectsBySubjectID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationGetApiV1TenantsByTenantIDSubjectsBySubjectIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationGetApiV1TenantsByTenantIDSubjectsBySubjectID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
