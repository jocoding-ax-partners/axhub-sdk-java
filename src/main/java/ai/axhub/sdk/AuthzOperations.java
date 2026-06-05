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
  public Map<String, Object> authorizationPostApiV1TenantsByTenantIDGrantsByGrantIDGrant(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPostApiV1TenantsByTenantIDGrantsByGrantIDGrant", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPostApiV1TenantsByTenantIDGrantsByGrantIDGrantAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPostApiV1TenantsByTenantIDGrantsByGrantIDGrant", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPostApiV1TenantsByTenantIDGrantsByGrantIDRevoke(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPostApiV1TenantsByTenantIDGrantsByGrantIDRevoke", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPostApiV1TenantsByTenantIDGrantsByGrantIDRevokeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPostApiV1TenantsByTenantIDGrantsByGrantIDRevoke", RouteOperations.map(pathParams), RouteOperations.map(query), body);
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
  public Map<String, Object> authorizationDeleteApiV1TenantsByTenantIDSubjectsBySubjectID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationDeleteApiV1TenantsByTenantIDSubjectsBySubjectID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationDeleteApiV1TenantsByTenantIDSubjectsBySubjectIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationDeleteApiV1TenantsByTenantIDSubjectsBySubjectID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPatchApiV1TenantsByTenantIDSubjectsBySubjectID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPatchApiV1TenantsByTenantIDSubjectsBySubjectID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPatchApiV1TenantsByTenantIDSubjectsBySubjectIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPatchApiV1TenantsByTenantIDSubjectsBySubjectID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPostApiV1TenantsByTenantIDSubjectsBySubjectIDMove(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPostApiV1TenantsByTenantIDSubjectsBySubjectIDMove", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPostApiV1TenantsByTenantIDSubjectsBySubjectIDMoveAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPostApiV1TenantsByTenantIDSubjectsBySubjectIDMove", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPostApiV1TenantsByTenantIDSubjectsBySubjectIDTags(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPostApiV1TenantsByTenantIDSubjectsBySubjectIDTags", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPostApiV1TenantsByTenantIDSubjectsBySubjectIDTagsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPostApiV1TenantsByTenantIDSubjectsBySubjectIDTags", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationDeleteApiV1TenantsByTenantIDSubjectsBySubjectIDTagsByTagID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationDeleteApiV1TenantsByTenantIDSubjectsBySubjectIDTagsByTagID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationDeleteApiV1TenantsByTenantIDSubjectsBySubjectIDTagsByTagIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationDeleteApiV1TenantsByTenantIDSubjectsBySubjectIDTagsByTagID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationGetApiV1TenantsByTenantIDTags(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationGetApiV1TenantsByTenantIDTags", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationGetApiV1TenantsByTenantIDTagsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationGetApiV1TenantsByTenantIDTags", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPostApiV1TenantsByTenantIDTags(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPostApiV1TenantsByTenantIDTags", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPostApiV1TenantsByTenantIDTagsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPostApiV1TenantsByTenantIDTags", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationDeleteApiV1TenantsByTenantIDTagsByTagID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationDeleteApiV1TenantsByTenantIDTagsByTagID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationDeleteApiV1TenantsByTenantIDTagsByTagIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationDeleteApiV1TenantsByTenantIDTagsByTagID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authorizationPatchApiV1TenantsByTenantIDTagsByTagID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authorizationPatchApiV1TenantsByTenantIDTagsByTagID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authorizationPatchApiV1TenantsByTenantIDTagsByTagIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authorizationPatchApiV1TenantsByTenantIDTagsByTagID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
