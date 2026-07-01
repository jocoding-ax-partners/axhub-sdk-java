package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class AppsOperations {
  private final AxHubClient c;
  AppsOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> appsGetApiV1AdminTemplates(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AdminTemplates", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AdminTemplatesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AdminTemplates", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AdminTemplates(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AdminTemplates", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AdminTemplatesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AdminTemplates", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AdminTemplatesByTemplateID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AdminTemplatesByTemplateID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AdminTemplatesByTemplateIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AdminTemplatesByTemplateID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPatchApiV1AdminTemplatesByTemplateID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPatchApiV1AdminTemplatesByTemplateID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPatchApiV1AdminTemplatesByTemplateIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPatchApiV1AdminTemplatesByTemplateID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1AppsByAppID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1AppsByAppID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1AppsByAppIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1AppsByAppID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AppsByAppID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AppsByAppID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AppsByAppIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AppsByAppID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPatchApiV1AppsByAppID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPatchApiV1AppsByAppID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPatchApiV1AppsByAppIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPatchApiV1AppsByAppID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1AppsByAppIDAccess(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1AppsByAppIDAccess", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1AppsByAppIDAccessAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1AppsByAppIDAccess", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDAccess(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDAccess", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDAccessAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDAccess", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AppsByAppIDAccessMe(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AppsByAppIDAccessMe", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AppsByAppIDAccessMeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AppsByAppIDAccessMe", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDArchive(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDArchive", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDArchiveAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDArchive", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AppsByAppIDComments(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AppsByAppIDComments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AppsByAppIDCommentsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AppsByAppIDComments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDComments(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDComments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDCommentsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDComments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AppsByAppIDEnvVars(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AppsByAppIDEnvVars", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AppsByAppIDEnvVarsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AppsByAppIDEnvVars", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDEnvVars(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDEnvVars", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDEnvVarsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDEnvVars", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1AppsByAppIDEnvVarsByKey(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1AppsByAppIDEnvVarsByKey", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1AppsByAppIDEnvVarsByKeyAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1AppsByAppIDEnvVarsByKey", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPutApiV1AppsByAppIDEnvVarsByKeyStagingValue(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPutApiV1AppsByAppIDEnvVarsByKeyStagingValue", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPutApiV1AppsByAppIDEnvVarsByKeyStagingValueAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPutApiV1AppsByAppIDEnvVarsByKeyStagingValue", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDIconDarkUploadUrl(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDIconDarkUploadUrl", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDIconDarkUploadUrlAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDIconDarkUploadUrl", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDIconUploadUrl(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDIconUploadUrl", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDIconUploadUrlAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDIconUploadUrl", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDInvitations(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDInvitations", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDInvitationsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDInvitations", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1AppsByAppIDInvitationsByUserID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1AppsByAppIDInvitationsByUserID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1AppsByAppIDInvitationsByUserIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1AppsByAppIDInvitationsByUserID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1AppsByAppIDLikes(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1AppsByAppIDLikes", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1AppsByAppIDLikesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1AppsByAppIDLikes", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDLikes(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDLikes", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDLikesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDLikes", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AppsByAppIDLikesMe(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AppsByAppIDLikesMe", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AppsByAppIDLikesMeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AppsByAppIDLikesMe", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AppsByAppIDMembers(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AppsByAppIDMembers", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AppsByAppIDMembersAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AppsByAppIDMembers", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1AppsByAppIDPermanent(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1AppsByAppIDPermanent", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1AppsByAppIDPermanentAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1AppsByAppIDPermanent", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1AppsByAppIDRawDb(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1AppsByAppIDRawDb", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1AppsByAppIDRawDbAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1AppsByAppIDRawDb", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDRawDb(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDRawDb", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDRawDbAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDRawDb", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDReactivate(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDReactivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDReactivateAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDReactivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDResume(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDResume", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDResumeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDResume", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AppsByAppIDReviewRequests(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AppsByAppIDReviewRequests", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AppsByAppIDReviewRequestsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AppsByAppIDReviewRequests", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDReviewRequests(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDReviewRequests", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDReviewRequestsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDReviewRequests", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1AppsByAppIDSuspend(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1AppsByAppIDSuspend", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1AppsByAppIDSuspendAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1AppsByAppIDSuspend", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AppsDiscover(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AppsDiscover", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AppsDiscoverAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AppsDiscover", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1AppsSearch(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1AppsSearch", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1AppsSearchAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1AppsSearch", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1CommentsByCommentID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1CommentsByCommentID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1CommentsByCommentIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1CommentsByCommentID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1MeAppsOwned(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1MeAppsOwned", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1MeAppsOwnedAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1MeAppsOwned", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1MeAppsReceived(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1MeAppsReceived", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1MeAppsReceivedAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1MeAppsReceived", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1MeAppsWorkspace(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1MeAppsWorkspace", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1MeAppsWorkspaceAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1MeAppsWorkspace", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1ResourcePresets(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1ResourcePresets", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1ResourcePresetsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1ResourcePresets", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1ReviewRequestsByRrID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1ReviewRequestsByRrID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1ReviewRequestsByRrIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1ReviewRequestsByRrID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1ReviewRequestsByRrIDApprove(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1ReviewRequestsByRrIDApprove", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1ReviewRequestsByRrIDApproveAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1ReviewRequestsByRrIDApprove", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1ReviewRequestsByRrIDReject(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1ReviewRequestsByRrIDReject", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1ReviewRequestsByRrIDRejectAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1ReviewRequestsByRrIDReject", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1ReviewRequestsHistory(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1ReviewRequestsHistory", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1ReviewRequestsHistoryAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1ReviewRequestsHistory", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1ReviewRequestsPending(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1ReviewRequestsPending", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1ReviewRequestsPendingAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1ReviewRequestsPending", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1StaticAuthStart(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1StaticAuthStart", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1StaticAuthStartAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1StaticAuthStart", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1Templates(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1Templates", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1TemplatesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1Templates", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1TenantsByTenantIDApps(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1TenantsByTenantIDApps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1TenantsByTenantIDAppsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1TenantsByTenantIDApps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDApps(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDApps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDApps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1TenantsByTenantIDAppsByAppIDStaticReleases(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1TenantsByTenantIDAppsByAppIDStaticReleases", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1TenantsByTenantIDAppsByAppIDStaticReleasesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1TenantsByTenantIDAppsByAppIDStaticReleases", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleases(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleases", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleases", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDActivate(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDActivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDActivateAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDActivate", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDFinalize(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDFinalize", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDFinalizeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDFinalize", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteApprove(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteApprove", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteApproveAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteApprove", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteReject(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteReject", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteRejectAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteReject", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteRequest(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteRequest", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteRequestAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDPromoteRequest", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDRollback(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDRollback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDRollbackAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDRollback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDStage(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDStage", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDStageAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticReleasesByReleaseIDStage", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1TenantsByTenantIDAppsByAppIDStaticSite(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1TenantsByTenantIDAppsByAppIDStaticSite", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1TenantsByTenantIDAppsByAppIDStaticSiteAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1TenantsByTenantIDAppsByAppIDStaticSite", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPatchApiV1TenantsByTenantIDAppsByAppIDStaticSite(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPatchApiV1TenantsByTenantIDAppsByAppIDStaticSite", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPatchApiV1TenantsByTenantIDAppsByAppIDStaticSiteAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPatchApiV1TenantsByTenantIDAppsByAppIDStaticSite", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteStagingDisable(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteStagingDisable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteStagingDisableAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteStagingDisable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteStagingEnable(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteStagingEnable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteStagingEnableAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteStagingEnable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteUnpublish(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteUnpublish", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteUnpublishAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsByAppIDStaticSiteUnpublish", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1TenantsByTenantIDAppsCheckAvailability(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1TenantsByTenantIDAppsCheckAvailability", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1TenantsByTenantIDAppsCheckAvailabilityAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1TenantsByTenantIDAppsCheckAvailability", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDAppsIconUploadUrl(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDAppsIconUploadUrl", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDAppsIconUploadUrlAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDAppsIconUploadUrl", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1TenantsByTenantIDCategories(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1TenantsByTenantIDCategories", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1TenantsByTenantIDCategoriesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1TenantsByTenantIDCategories", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPostApiV1TenantsByTenantIDCategories(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPostApiV1TenantsByTenantIDCategories", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPostApiV1TenantsByTenantIDCategoriesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPostApiV1TenantsByTenantIDCategories", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsDeleteApiV1TenantsByTenantIDCategoriesByCategoryID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsDeleteApiV1TenantsByTenantIDCategoriesByCategoryID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsDeleteApiV1TenantsByTenantIDCategoriesByCategoryIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsDeleteApiV1TenantsByTenantIDCategoriesByCategoryID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1TenantsByTenantIDCategoriesByCategoryID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1TenantsByTenantIDCategoriesByCategoryID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1TenantsByTenantIDCategoriesByCategoryIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1TenantsByTenantIDCategoriesByCategoryID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsPatchApiV1TenantsByTenantIDCategoriesByCategoryID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPatchApiV1TenantsByTenantIDCategoriesByCategoryID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPatchApiV1TenantsByTenantIDCategoriesByCategoryIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPatchApiV1TenantsByTenantIDCategoriesByCategoryID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1TenantsByTenantIDDiscoverApps(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1TenantsByTenantIDDiscoverApps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1TenantsByTenantIDDiscoverAppsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1TenantsByTenantIDDiscoverApps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetApiV1UsersMeApps(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1UsersMeApps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1UsersMeAppsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1UsersMeApps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> appsGetInternalAppAccess(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetInternalAppAccess", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetInternalAppAccessAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetInternalAppAccess", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
