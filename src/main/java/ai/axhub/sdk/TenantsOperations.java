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
  public Map<String, Object> tenantsPostApiV1Tenants(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1Tenants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1Tenants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsDeleteApiV1TenantsByTenantID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsDeleteApiV1TenantsByTenantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsDeleteApiV1TenantsByTenantIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsDeleteApiV1TenantsByTenantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetApiV1TenantsByTenantID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPatchApiV1TenantsByTenantID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPatchApiV1TenantsByTenantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPatchApiV1TenantsByTenantIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPatchApiV1TenantsByTenantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsDeleteApiV1TenantsByTenantIDIcon(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsDeleteApiV1TenantsByTenantIDIcon", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsDeleteApiV1TenantsByTenantIDIconAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsDeleteApiV1TenantsByTenantIDIcon", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDIconUploadUrl(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDIconUploadUrl", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDIconUploadUrlAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDIconUploadUrl", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetApiV1TenantsByTenantIDInvitations(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantIDInvitations", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDInvitationsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantIDInvitations", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDInvitations(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDInvitations", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDInvitationsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDInvitations", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsDeleteApiV1TenantsByTenantIDInvitationsByInvitationID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsDeleteApiV1TenantsByTenantIDInvitationsByInvitationID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsDeleteApiV1TenantsByTenantIDInvitationsByInvitationIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsDeleteApiV1TenantsByTenantIDInvitationsByInvitationID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDInvitationsBulk(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDInvitationsBulk", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDInvitationsBulkAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDInvitationsBulk", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetApiV1TenantsByTenantIDMembers(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantIDMembers", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDMembersAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantIDMembers", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPatchApiV1TenantsByTenantIDMembersByMembershipID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPatchApiV1TenantsByTenantIDMembersByMembershipID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPatchApiV1TenantsByTenantIDMembersByMembershipIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPatchApiV1TenantsByTenantIDMembersByMembershipID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDDeactivate(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDDeactivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDDeactivateAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDDeactivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDReactivate(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDReactivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDReactivateAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDReactivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetTenantsByTenantIDEmailDomains(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetTenantsByTenantIDEmailDomains", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetTenantsByTenantIDEmailDomainsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetTenantsByTenantIDEmailDomains", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostTenantsByTenantIDEmailDomains(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostTenantsByTenantIDEmailDomains", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostTenantsByTenantIDEmailDomainsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostTenantsByTenantIDEmailDomains", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsDeleteTenantsByTenantIDEmailDomainsByDomain(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsDeleteTenantsByTenantIDEmailDomainsByDomain", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsDeleteTenantsByTenantIDEmailDomainsByDomainAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsDeleteTenantsByTenantIDEmailDomainsByDomain", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
