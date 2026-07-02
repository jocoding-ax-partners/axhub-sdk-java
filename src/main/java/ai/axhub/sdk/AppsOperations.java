package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class AppsOperations {
  private final AxHubClient c;
  AppsOperations(AxHubClient c) { this.c = c; }
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
  public Map<String, Object> appsPutApiV1AppsByAppIDEnvVarsByKeyStagingValue(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsPutApiV1AppsByAppIDEnvVarsByKeyStagingValue", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsPutApiV1AppsByAppIDEnvVarsByKeyStagingValueAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsPutApiV1AppsByAppIDEnvVarsByKeyStagingValue", RouteOperations.map(pathParams), RouteOperations.map(query), body);
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
  public Map<String, Object> appsGetApiV1TenantsByTenantIDAppsCheckAvailability(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("appsGetApiV1TenantsByTenantIDAppsCheckAvailability", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> appsGetApiV1TenantsByTenantIDAppsCheckAvailabilityAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("appsGetApiV1TenantsByTenantIDAppsCheckAvailability", RouteOperations.map(pathParams), RouteOperations.map(query), body);
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
}
