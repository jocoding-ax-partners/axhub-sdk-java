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
  public Map<String, Object> authGetWellKnownOpenidConfiguration(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetWellKnownOpenidConfiguration", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetWellKnownOpenidConfigurationAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetWellKnownOpenidConfiguration", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostApiV1AdminUsersByUidRevokeAll(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostApiV1AdminUsersByUidRevokeAll", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostApiV1AdminUsersByUidRevokeAllAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostApiV1AdminUsersByUidRevokeAll", RouteOperations.map(pathParams), RouteOperations.map(query), body);
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
  public Map<String, Object> authPostApiV1MeInvitationsByInvitationIDAccept(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostApiV1MeInvitationsByInvitationIDAccept", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostApiV1MeInvitationsByInvitationIDAcceptAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostApiV1MeInvitationsByInvitationIDAccept", RouteOperations.map(pathParams), RouteOperations.map(query), body);
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
  public Map<String, Object> authGetApiV1TenantsByTenantIDIdentityProviders(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetApiV1TenantsByTenantIDIdentityProviders", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetApiV1TenantsByTenantIDIdentityProvidersAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetApiV1TenantsByTenantIDIdentityProviders", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostApiV1TenantsByTenantIDIdentityProviders(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostApiV1TenantsByTenantIDIdentityProviders", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostApiV1TenantsByTenantIDIdentityProvidersAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostApiV1TenantsByTenantIDIdentityProviders", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostApiV1TenantsByTenantIDIdentityProvidersByProviderIDDisable(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostApiV1TenantsByTenantIDIdentityProvidersByProviderIDDisable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostApiV1TenantsByTenantIDIdentityProvidersByProviderIDDisableAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostApiV1TenantsByTenantIDIdentityProvidersByProviderIDDisable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostApiV1TenantsByTenantIDIdentityProvidersByProviderIDEnable(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostApiV1TenantsByTenantIDIdentityProvidersByProviderIDEnable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostApiV1TenantsByTenantIDIdentityProvidersByProviderIDEnableAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostApiV1TenantsByTenantIDIdentityProvidersByProviderIDEnable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetAuthByProviderIDStart(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetAuthByProviderIDStart", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetAuthByProviderIDStartAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetAuthByProviderIDStart", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> identityGetAuthGithub(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("identityGetAuthGithub", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> identityGetAuthGithubAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("identityGetAuthGithub", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> identityGetAuthGithubCallback(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("identityGetAuthGithubCallback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> identityGetAuthGithubCallbackAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("identityGetAuthGithubCallback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetAuthGoogleOauth2Callback(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetAuthGoogleOauth2Callback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetAuthGoogleOauth2CallbackAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetAuthGoogleOauth2Callback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetAuthGoogleOauth2Start(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetAuthGoogleOauth2Start", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetAuthGoogleOauth2StartAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetAuthGoogleOauth2Start", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostAuthLogout(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostAuthLogout", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostAuthLogoutAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostAuthLogout", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetAuthOidcCallback(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetAuthOidcCallback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetAuthOidcCallbackAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetAuthOidcCallback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetAuthProviders(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetAuthProviders", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetAuthProvidersAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetAuthProviders", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostAuthRefresh(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostAuthRefresh", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostAuthRefreshAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostAuthRefresh", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetAuthSilentCallback(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetAuthSilentCallback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetAuthSilentCallbackAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetAuthSilentCallback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetAuthSilentStart(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetAuthSilentStart", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetAuthSilentStartAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetAuthSilentStart", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetOauthAuthorize(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetOauthAuthorize", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetOauthAuthorizeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetOauthAuthorize", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostOauthAuthorizeTenant(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostOauthAuthorizeTenant", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostOauthAuthorizeTenantAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostOauthAuthorizeTenant", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostOauthDeviceAuthorization(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostOauthDeviceAuthorization", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostOauthDeviceAuthorizationAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostOauthDeviceAuthorization", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostOauthDeviceAuthorize(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostOauthDeviceAuthorize", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostOauthDeviceAuthorizeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostOauthDeviceAuthorize", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetOauthDeviceLookup(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetOauthDeviceLookup", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetOauthDeviceLookupAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetOauthDeviceLookup", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostOauthRegister(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostOauthRegister", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostOauthRegisterAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostOauthRegister", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostOauthRevoke(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostOauthRevoke", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostOauthRevokeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostOauthRevoke", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authPostOauthToken(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authPostOauthToken", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authPostOauthTokenAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authPostOauthToken", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> authGetOauthUserinfo(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("authGetOauthUserinfo", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> authGetOauthUserinfoAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("authGetOauthUserinfo", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
