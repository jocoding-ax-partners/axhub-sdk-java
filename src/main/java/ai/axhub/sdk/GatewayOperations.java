package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class GatewayOperations {
  private final AxHubClient c;
  GatewayOperations(AxHubClient c) { this.c = c; }
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
  public Map<String, Object> gatewayGetApiV1TenantsByTenantIDConnectorsByConnectorID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1TenantsByTenantIDConnectorsByConnectorID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1TenantsByTenantIDConnectorsByConnectorIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1TenantsByTenantIDConnectorsByConnectorID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPatchApiV1TenantsByTenantIDConnectorsByConnectorID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPatchApiV1TenantsByTenantIDConnectorsByConnectorID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPatchApiV1TenantsByTenantIDConnectorsByConnectorIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPatchApiV1TenantsByTenantIDConnectorsByConnectorID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDConnectorsByConnectorIDTestConnection(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDConnectorsByConnectorIDTestConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDConnectorsByConnectorIDTestConnectionAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDConnectorsByConnectorIDTestConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDGatewayInvoke(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDGatewayInvoke", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDGatewayInvokeAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDGatewayInvoke", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDGatewayQuery(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDGatewayQuery", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDGatewayQueryAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDGatewayQuery", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayPostApiV1TenantsByTenantIDGatewaySessions(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayPostApiV1TenantsByTenantIDGatewaySessions", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayPostApiV1TenantsByTenantIDGatewaySessionsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayPostApiV1TenantsByTenantIDGatewaySessions", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayDeleteApiV1TenantsByTenantIDGatewaySessionsBySessionID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayDeleteApiV1TenantsByTenantIDGatewaySessionsBySessionID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayDeleteApiV1TenantsByTenantIDGatewaySessionsBySessionIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayDeleteApiV1TenantsByTenantIDGatewaySessionsBySessionID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayGetApiV1TenantsByTenantIDMeConnectors(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1TenantsByTenantIDMeConnectors", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1TenantsByTenantIDMeConnectorsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1TenantsByTenantIDMeConnectors", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> gatewayGetApiV1TenantsByTenantIDMeConnectorsByConnectorIDResources(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("gatewayGetApiV1TenantsByTenantIDMeConnectorsByConnectorIDResources", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> gatewayGetApiV1TenantsByTenantIDMeConnectorsByConnectorIDResourcesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("gatewayGetApiV1TenantsByTenantIDMeConnectorsByConnectorIDResources", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> configGetConfigPublic(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("configGetConfigPublic", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> configGetConfigPublicAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("configGetConfigPublic", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
