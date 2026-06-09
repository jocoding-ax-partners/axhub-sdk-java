package ai.axhub.sdk.data;

import ai.axhub.sdk.AxHubClient;
import ai.axhub.sdk.data.Schema.DataTableSchema;

/**
 * Entry point for the ergonomic data layer; holds the per-client schema cache
 * used by {@code discover()} (mirrors node DataClient and the Python port's
 * DataClient).
 *
 * <p>One {@code DataClient} lives per {@link AxHubClient}, so the schema cache
 * persists across separate {@code tenant().app()} chains — two {@code discover()}
 * calls for the same table hit the inspect endpoint once.
 */
public final class DataClient {
  private final AxHubClient client;
  private final SchemaCache schemaCache;

  public DataClient(AxHubClient client) {
    this(client, new SchemaCache());
  }

  public DataClient(AxHubClient client, SchemaCache schemaCache) {
    this.client = client;
    this.schemaCache = schemaCache;
  }

  public DataTableClient table(String tenantSlug, String appSlug, String table) {
    return new DataTableClient(client, tenantSlug, appSlug, table, null);
  }

  public DataTableClient table(String tenantSlug, String appSlug, DataTableSchema schema) {
    return new DataTableClient(client, tenantSlug, appSlug, schema.table(), schema);
  }

  public TenantScope scoped(String tenantSlug) {
    return new TenantScope(this, tenantSlug);
  }

  public DataTableClient discover(String tenantSlug, String appSlug, String table) {
    return discover(tenantSlug, appSlug, table, null, null);
  }

  public DataTableClient discover(String tenantSlug, String appSlug, String table, Boolean fresh, Integer ttlMs) {
    String key = SchemaCache.schemaCacheKey(tenantSlug, appSlug, table);
    DataTableSchema schema = schemaCache.getOrSet(
        key,
        () -> Discover.fetchDiscoveredSchema(client, tenantSlug, appSlug, table),
        fresh,
        ttlMs);
    return new DataTableClient(client, tenantSlug, appSlug, schema.table(), schema);
  }

  public void invalidateSchema() {
    schemaCache.invalidate();
  }

  public void invalidateSchema(String tenantSlug, String appSlug, String table) {
    schemaCache.invalidate(SchemaCache.schemaCacheKey(tenantSlug, appSlug, table));
  }

  public SchemaCache schemaCache() {
    return schemaCache;
  }
}
