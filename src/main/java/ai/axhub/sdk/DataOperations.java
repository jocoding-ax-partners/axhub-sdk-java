package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class DataOperations {
  private final AxHubClient c;
  DataOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> schemaGetApiV1AppsByAppIDDbTables(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetApiV1AppsByAppIDDbTables", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetApiV1AppsByAppIDDbTablesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetApiV1AppsByAppIDDbTables", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaGetApiV1AppsByAppIDDbTablesByTableRows(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetApiV1AppsByAppIDDbTablesByTableRows", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetApiV1AppsByAppIDDbTablesByTableRowsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetApiV1AppsByAppIDDbTablesByTableRows", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaGetApiV1MePersonalAccessTokens(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetApiV1MePersonalAccessTokens", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetApiV1MePersonalAccessTokensAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetApiV1MePersonalAccessTokens", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaPostApiV1MePersonalAccessTokens(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaPostApiV1MePersonalAccessTokens", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaPostApiV1MePersonalAccessTokensAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaPostApiV1MePersonalAccessTokens", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaDeleteApiV1MePersonalAccessTokensByPatID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaDeleteApiV1MePersonalAccessTokensByPatID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaDeleteApiV1MePersonalAccessTokensByPatIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaDeleteApiV1MePersonalAccessTokensByPatID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
