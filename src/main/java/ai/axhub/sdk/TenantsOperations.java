package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class TenantsOperations {
  private final AxHubClient c;
  TenantsOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> tenantsGetApiV1InviteLinksByToken(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1InviteLinksByToken", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1InviteLinksByTokenAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1InviteLinksByToken", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1InviteLinksByTokenAccept(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1InviteLinksByTokenAccept", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1InviteLinksByTokenAcceptAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1InviteLinksByTokenAccept", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
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
  public Map<String, Object> tenantsGetApiV1TenantsByTenantIDEmailDomains(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantIDEmailDomains", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDEmailDomainsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantIDEmailDomains", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDEmailDomains(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDEmailDomains", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDEmailDomainsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDEmailDomains", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsDeleteApiV1TenantsByTenantIDEmailDomainsByDomain(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsDeleteApiV1TenantsByTenantIDEmailDomainsByDomain", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsDeleteApiV1TenantsByTenantIDEmailDomainsByDomainAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsDeleteApiV1TenantsByTenantIDEmailDomainsByDomain", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetApiV1TenantsByTenantIDGroups(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantIDGroups", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDGroupsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantIDGroups", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDGroups(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDGroups", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDGroupsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDGroups", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsDeleteApiV1TenantsByTenantIDGroupsByGroupID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsDeleteApiV1TenantsByTenantIDGroupsByGroupID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsDeleteApiV1TenantsByTenantIDGroupsByGroupIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsDeleteApiV1TenantsByTenantIDGroupsByGroupID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPatchApiV1TenantsByTenantIDGroupsByGroupID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPatchApiV1TenantsByTenantIDGroupsByGroupID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPatchApiV1TenantsByTenantIDGroupsByGroupIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPatchApiV1TenantsByTenantIDGroupsByGroupID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
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
  public Map<String, Object> tenantsGetApiV1TenantsByTenantIDInviteLinks(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantIDInviteLinks", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDInviteLinksAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantIDInviteLinks", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDInviteLinks(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDInviteLinks", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDInviteLinksAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDInviteLinks", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsDeleteApiV1TenantsByTenantIDInviteLinksByLinkID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsDeleteApiV1TenantsByTenantIDInviteLinksByLinkID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsDeleteApiV1TenantsByTenantIDInviteLinksByLinkIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsDeleteApiV1TenantsByTenantIDInviteLinksByLinkID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
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
  public Map<String, Object> tenantsPatchApiV1TenantsByTenantIDMembersByMembershipIDGroup(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPatchApiV1TenantsByTenantIDMembersByMembershipIDGroup", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPatchApiV1TenantsByTenantIDMembersByMembershipIDGroupAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPatchApiV1TenantsByTenantIDMembersByMembershipIDGroup", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDReactivate(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDReactivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDReactivateAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDReactivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDRestoreScim(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDRestoreScim", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDRestoreScimAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDMembersByMembershipIDRestoreScim", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsDeleteApiV1TenantsByTenantIDMembersByUserIDSeat(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsDeleteApiV1TenantsByTenantIDMembersByUserIDSeat", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsDeleteApiV1TenantsByTenantIDMembersByUserIDSeatAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsDeleteApiV1TenantsByTenantIDMembersByUserIDSeat", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDMembersByUserIDSeat(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDMembersByUserIDSeat", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDMembersByUserIDSeatAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDMembersByUserIDSeat", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetApiV1TenantsByTenantIDMembersDirectory(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantIDMembersDirectory", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDMembersDirectoryAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantIDMembersDirectory", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsGetApiV1TenantsByTenantIDScimConnection(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsGetApiV1TenantsByTenantIDScimConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsGetApiV1TenantsByTenantIDScimConnectionAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsGetApiV1TenantsByTenantIDScimConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsDeleteApiV1TenantsByTenantIDScimToken(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsDeleteApiV1TenantsByTenantIDScimToken", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsDeleteApiV1TenantsByTenantIDScimTokenAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsDeleteApiV1TenantsByTenantIDScimToken", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> tenantsPostApiV1TenantsByTenantIDScimToken(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("tenantsPostApiV1TenantsByTenantIDScimToken", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> tenantsPostApiV1TenantsByTenantIDScimTokenAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("tenantsPostApiV1TenantsByTenantIDScimToken", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
