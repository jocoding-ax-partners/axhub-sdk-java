package ai.axhub.sdk.data;

/**
 * Fluent tenant scope: {@code client.tenant(t).app(a)}. Cheap holder that
 * references the per-client {@link DataClient} (mirrors node TenantDataFactory).
 */
public final class TenantScope {
  private final DataClient data;
  private final String tenantSlug;

  public TenantScope(DataClient data, String tenantSlug) {
    this.data = data;
    this.tenantSlug = tenantSlug;
  }

  public AppScope app(String appSlug) {
    return new AppScope(data, tenantSlug, appSlug);
  }
}
