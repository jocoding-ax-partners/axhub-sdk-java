package ai.axhub.sdk.data;

import ai.axhub.sdk.data.Schema.DataTableSchema;

/**
 * App-bound factory for the ergonomic data layer (mirrors node AppDataFactory).
 * Reached via {@code client.tenant(t).app(a).data()}.
 */
public final class AppDataFactory {
  private final DataClient data;
  private final String tenantSlug;
  private final String appSlug;

  public AppDataFactory(DataClient data, String tenantSlug, String appSlug) {
    this.data = data;
    this.tenantSlug = tenantSlug;
    this.appSlug = appSlug;
  }

  public DataTableClient table(String table) {
    return data.table(tenantSlug, appSlug, table);
  }

  public DataTableClient table(DataTableSchema schema) {
    return data.table(tenantSlug, appSlug, schema);
  }

  public DataTableClient discover(String table) {
    return data.discover(tenantSlug, appSlug, table);
  }

  public DataTableClient discover(String table, Boolean fresh, Integer ttlMs) {
    return data.discover(tenantSlug, appSlug, table, fresh, ttlMs);
  }

  public void invalidateSchema() {
    data.invalidateSchema();
  }

  public void invalidateSchema(String table) {
    data.invalidateSchema(tenantSlug, appSlug, table);
  }
}
