package ai.axhub.sdk.data;

/**
 * Fluent app scope: {@code client.tenant(t).app(a)}. Exposes {@code .data()} to
 * reach the ergonomic data layer, mirroring the node {@code sdk.tenant().app().data}
 * surface.
 */
public final class AppScope {
  private final DataClient data;
  private final String tenantSlug;
  private final String appSlug;

  public AppScope(DataClient data, String tenantSlug, String appSlug) {
    this.data = data;
    this.tenantSlug = tenantSlug;
    this.appSlug = appSlug;
  }

  /** The ergonomic data factory bound to this {@code tenant/app}. */
  public AppDataFactory data() {
    return new AppDataFactory(data, tenantSlug, appSlug);
  }
}
