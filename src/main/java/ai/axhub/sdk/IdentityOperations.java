package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class IdentityOperations {
  private final AxHubClient c;
  IdentityOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> authGetWellKnownJwksJson(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetWellKnownJwksJson", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetWellKnownJwksJsonAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetWellKnownJwksJson", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetWellKnownOauthAuthorizationServer(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetWellKnownOauthAuthorizationServer", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetWellKnownOauthAuthorizationServerAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetWellKnownOauthAuthorizationServer", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetWellKnownOpenidConfiguration(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetWellKnownOpenidConfiguration", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetWellKnownOpenidConfigurationAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetWellKnownOpenidConfiguration", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostApiV1AppsByAppIDOauthClients(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostApiV1AppsByAppIDOauthClients", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostApiV1AppsByAppIDOauthClientsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostApiV1AppsByAppIDOauthClients", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetApiV1Me(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetApiV1Me", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetApiV1MeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetApiV1Me", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetApiV1OauthClientsByClientID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetApiV1OauthClientsByClientID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetApiV1OauthClientsByClientIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetApiV1OauthClientsByClientID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authDeleteApiV1OauthClientsByClientIDGrantsMe(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authDeleteApiV1OauthClientsByClientIDGrantsMe", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authDeleteApiV1OauthClientsByClientIDGrantsMeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authDeleteApiV1OauthClientsByClientIDGrantsMe", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostAuthLogout(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostAuthLogout", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostAuthLogoutAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostAuthLogout", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostAuthRefresh(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostAuthRefresh", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostAuthRefreshAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostAuthRefresh", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetOauthUserinfo(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetOauthUserinfo", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetOauthUserinfoAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetOauthUserinfo", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
