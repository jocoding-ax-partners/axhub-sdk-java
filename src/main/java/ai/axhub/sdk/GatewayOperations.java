package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class GatewayOperations {
  private final AxHubClient c;
  GatewayOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> gatewayGetApiV1CatalogKinds(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1CatalogKinds", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1CatalogKindsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1CatalogKinds", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayGetApiV1Engines(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1Engines", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1EnginesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1Engines", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayGetApiV1TenantsByTenantIDCatalogConnectors(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1TenantsByTenantIDCatalogConnectors", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1TenantsByTenantIDCatalogConnectorsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1TenantsByTenantIDCatalogConnectors", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayGetApiV1TenantsByTenantIDCatalogResources(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1TenantsByTenantIDCatalogResources", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1TenantsByTenantIDCatalogResourcesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1TenantsByTenantIDCatalogResources", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayGetApiV1TenantsByTenantIDCatalogResourcesByConnectorByPath(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1TenantsByTenantIDCatalogResourcesByConnectorByPath", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1TenantsByTenantIDCatalogResourcesByConnectorByPathAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1TenantsByTenantIDCatalogResourcesByConnectorByPath", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDCatalogResourcesByConnectorByPath(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDCatalogResourcesByConnectorByPath", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDCatalogResourcesByConnectorByPathAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDCatalogResourcesByConnectorByPath", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayGetApiV1TenantsByTenantIDConnectors(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1TenantsByTenantIDConnectors", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1TenantsByTenantIDConnectorsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1TenantsByTenantIDConnectors", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDConnectors(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDConnectors", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDConnectorsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDConnectors", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayDeleteApiV1TenantsByTenantIDConnectorsByConnectorID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayDeleteApiV1TenantsByTenantIDConnectorsByConnectorID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayDeleteApiV1TenantsByTenantIDConnectorsByConnectorIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayDeleteApiV1TenantsByTenantIDConnectorsByConnectorID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPatchApiV1TenantsByTenantIDConnectorsByConnectorID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPatchApiV1TenantsByTenantIDConnectorsByConnectorID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPatchApiV1TenantsByTenantIDConnectorsByConnectorIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPatchApiV1TenantsByTenantIDConnectorsByConnectorID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDConnectorsByConnectorIDCredentials(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDConnectorsByConnectorIDCredentials", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDConnectorsByConnectorIDCredentialsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDConnectorsByConnectorIDCredentials", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayGetApiV1TenantsByTenantIDConnectorsByConnectorIDDiscover(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1TenantsByTenantIDConnectorsByConnectorIDDiscover", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1TenantsByTenantIDConnectorsByConnectorIDDiscoverAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1TenantsByTenantIDConnectorsByConnectorIDDiscover", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDGatewayQuery(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDGatewayQuery", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDGatewayQueryAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDGatewayQuery", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayGetApiV1TenantsByTenantIDResources(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1TenantsByTenantIDResources", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1TenantsByTenantIDResourcesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1TenantsByTenantIDResources", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayDeleteApiV1TenantsByTenantIDResourcesByResourceID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayDeleteApiV1TenantsByTenantIDResourcesByResourceID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayDeleteApiV1TenantsByTenantIDResourcesByResourceIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayDeleteApiV1TenantsByTenantIDResourcesByResourceID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPatchApiV1TenantsByTenantIDResourcesByResourceID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPatchApiV1TenantsByTenantIDResourcesByResourceID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPatchApiV1TenantsByTenantIDResourcesByResourceIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPatchApiV1TenantsByTenantIDResourcesByResourceID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDResourcesByResourceIDMove(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDResourcesByResourceIDMove", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDResourcesByResourceIDMoveAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDResourcesByResourceIDMove", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDResourcesByResourceIDTags(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDResourcesByResourceIDTags", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDResourcesByResourceIDTagsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDResourcesByResourceIDTags", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayDeleteApiV1TenantsByTenantIDResourcesByResourceIDTagsByTagID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayDeleteApiV1TenantsByTenantIDResourcesByResourceIDTagsByTagID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayDeleteApiV1TenantsByTenantIDResourcesByResourceIDTagsByTagIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayDeleteApiV1TenantsByTenantIDResourcesByResourceIDTagsByTagID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDResourcesBulk(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDResourcesBulk", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDResourcesBulkAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDResourcesBulk", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDResourcesNamespaces(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDResourcesNamespaces", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDResourcesNamespacesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDResourcesNamespaces", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> configGetConfigPublic(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("configGetConfigPublic", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> configGetConfigPublicAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("configGetConfigPublic", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
