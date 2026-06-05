package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class DataOperations {
  private final AxHubClient c;
  DataOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> schemaGetApiV1AppsByAppIDTables(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetApiV1AppsByAppIDTables", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetApiV1AppsByAppIDTablesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetApiV1AppsByAppIDTables", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaPostApiV1AppsByAppIDTables(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaPostApiV1AppsByAppIDTables", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaPostApiV1AppsByAppIDTablesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaPostApiV1AppsByAppIDTables", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaDeleteApiV1AppsByAppIDTablesByTableName(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaDeleteApiV1AppsByAppIDTablesByTableName", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaDeleteApiV1AppsByAppIDTablesByTableNameAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaDeleteApiV1AppsByAppIDTablesByTableName", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaGetApiV1AppsByAppIDTablesByTableName(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetApiV1AppsByAppIDTablesByTableName", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetApiV1AppsByAppIDTablesByTableNameAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetApiV1AppsByAppIDTablesByTableName", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaPostApiV1AppsByAppIDTablesByTableNameColumns(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaPostApiV1AppsByAppIDTablesByTableNameColumns", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaPostApiV1AppsByAppIDTablesByTableNameColumnsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaPostApiV1AppsByAppIDTablesByTableNameColumns", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaDeleteApiV1AppsByAppIDTablesByTableNameColumnsByColumnName(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaDeleteApiV1AppsByAppIDTablesByTableNameColumnsByColumnName", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaDeleteApiV1AppsByAppIDTablesByTableNameColumnsByColumnNameAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaDeleteApiV1AppsByAppIDTablesByTableNameColumnsByColumnName", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaGetApiV1AppsByAppIDTablesByTableNameGrants(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetApiV1AppsByAppIDTablesByTableNameGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetApiV1AppsByAppIDTablesByTableNameGrantsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetApiV1AppsByAppIDTablesByTableNameGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaPostApiV1AppsByAppIDTablesByTableNameGrants(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaPostApiV1AppsByAppIDTablesByTableNameGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaPostApiV1AppsByAppIDTablesByTableNameGrantsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaPostApiV1AppsByAppIDTablesByTableNameGrants", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaDeleteApiV1AppsByAppIDTablesByTableNameGrantsByGrantID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaDeleteApiV1AppsByAppIDTablesByTableNameGrantsByGrantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaDeleteApiV1AppsByAppIDTablesByTableNameGrantsByGrantIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaDeleteApiV1AppsByAppIDTablesByTableNameGrantsByGrantID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaGetApiV1AppsByAppIDTablesByTableNameRows(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetApiV1AppsByAppIDTablesByTableNameRows", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetApiV1AppsByAppIDTablesByTableNameRowsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetApiV1AppsByAppIDTablesByTableNameRows", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaGetApiV1AppsByAppIDTablesCheckAvailability(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetApiV1AppsByAppIDTablesCheckAvailability", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetApiV1AppsByAppIDTablesCheckAvailabilityAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetApiV1AppsByAppIDTablesCheckAvailability", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaGetApiV1AppsByAppIDTablesColumnTypes(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetApiV1AppsByAppIDTablesColumnTypes", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetApiV1AppsByAppIDTablesColumnTypesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetApiV1AppsByAppIDTablesColumnTypes", RouteOperations.map(pathParams), RouteOperations.map(query), body);
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
  public Map<String, Object> schemaGetDataByTenantSlugByAppSlugByTable(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetDataByTenantSlugByAppSlugByTable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetDataByTenantSlugByAppSlugByTableAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetDataByTenantSlugByAppSlugByTable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaPostDataByTenantSlugByAppSlugByTable(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaPostDataByTenantSlugByAppSlugByTable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaPostDataByTenantSlugByAppSlugByTableAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaPostDataByTenantSlugByAppSlugByTable", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaGetDataByTenantSlugByAppSlugByTableCount(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetDataByTenantSlugByAppSlugByTableCount", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetDataByTenantSlugByAppSlugByTableCountAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetDataByTenantSlugByAppSlugByTableCount", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaDeleteDataByTenantSlugByAppSlugByTableById(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaDeleteDataByTenantSlugByAppSlugByTableById", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaDeleteDataByTenantSlugByAppSlugByTableByIdAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaDeleteDataByTenantSlugByAppSlugByTableById", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaGetDataByTenantSlugByAppSlugByTableById(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaGetDataByTenantSlugByAppSlugByTableById", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaGetDataByTenantSlugByAppSlugByTableByIdAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaGetDataByTenantSlugByAppSlugByTableById", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> schemaPatchDataByTenantSlugByAppSlugByTableById(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("schemaPatchDataByTenantSlugByAppSlugByTableById", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> schemaPatchDataByTenantSlugByAppSlugByTableByIdAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("schemaPatchDataByTenantSlugByAppSlugByTableById", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
