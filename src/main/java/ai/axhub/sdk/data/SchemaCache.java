package ai.axhub.sdk.data;

import ai.axhub.sdk.AxHubException;
import ai.axhub.sdk.data.Schema.DataTableSchema;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Per-client schema cache for runtime {@code data.discover()} (mirrors node
 * schema-cache.ts and the Python port's schema_cache.py).
 *
 * <p>Uses a {@link LinkedHashMap} in access order for deterministic LRU eviction
 * (move-to-end on read/write) and a negative-TTL stale-while-error window: a
 * transient 5xx during refresh keeps the previous entry alive briefly instead of
 * evicting it. Like the Python port, the node in-flight de-dup map is omitted
 * (no concurrency within a single synchronous call) — see gap-matrix.
 */
public final class SchemaCache {
  public static final int DEFAULT_SCHEMA_CACHE_TTL_MS = 5 * 60_000;
  public static final int DEFAULT_SCHEMA_CACHE_MAX_ENTRIES = 1000;
  public static final int DEFAULT_SCHEMA_CACHE_NEGATIVE_TTL_MS = 30_000;

  private record Entry(DataTableSchema schema, long expiresAt) {}

  private final LinkedHashMap<String, Entry> store;
  private final int maxEntries;
  private final int ttlMs;
  private final int negativeTtlMs;

  public SchemaCache() {
    this(null, null, null);
  }

  public SchemaCache(Integer maxEntries, Integer ttlMs, Integer negativeTtlMs) {
    this.maxEntries = Math.max(1, maxEntries != null ? maxEntries : DEFAULT_SCHEMA_CACHE_MAX_ENTRIES);
    this.ttlMs = Math.max(1, ttlMs != null ? ttlMs : DEFAULT_SCHEMA_CACHE_TTL_MS);
    this.negativeTtlMs = Math.max(0, negativeTtlMs != null ? negativeTtlMs : DEFAULT_SCHEMA_CACHE_NEGATIVE_TTL_MS);
    this.store = new LinkedHashMap<>(16, 0.75f, true); // access-order for LRU
  }

  private static long nowMs() {
    return System.nanoTime() / 1_000_000L;
  }

  public synchronized int size() {
    return store.size();
  }

  public synchronized DataTableSchema get(String key) {
    Entry entry = store.get(key); // access-order touch
    if (entry == null) return null;
    if (entry.expiresAt() <= nowMs()) {
      store.remove(key);
      return null;
    }
    return entry.schema();
  }

  public synchronized void set(String key, DataTableSchema schema, Integer ttlMs) {
    store.remove(key);
    int effectiveTtl = Math.max(1, ttlMs != null ? ttlMs : this.ttlMs);
    store.put(key, new Entry(schema, nowMs() + effectiveTtl));
    evictOverflow();
  }

  public synchronized void invalidate() {
    store.clear();
  }

  public synchronized void invalidate(String key) {
    store.remove(key);
  }

  /**
   * Return the cached schema or load + cache it. On a transient 5xx during
   * refresh, the previous entry (if any) is kept alive for {@code negativeTtlMs}
   * (stale-while-error), then the error is rethrown.
   */
  public DataTableSchema getOrSet(String key, Supplier<DataTableSchema> loader, Boolean fresh, Integer ttlMs) {
    if (fresh == null || !fresh) {
      DataTableSchema cached = get(key);
      if (cached != null) return cached;
    }
    Entry previous;
    synchronized (this) {
      previous = store.get(key);
    }
    DataTableSchema schema;
    try {
      schema = loader.get();
    } catch (RuntimeException err) {
      if (previous != null && negativeTtlMs > 0 && isTransientServerError(err)) {
        synchronized (this) {
          store.remove(key);
          store.put(key, new Entry(previous.schema(), nowMs() + negativeTtlMs));
        }
      }
      throw err;
    }
    set(key, schema, ttlMs);
    return schema;
  }

  private void evictOverflow() {
    while (store.size() > maxEntries) {
      String oldest = store.keySet().iterator().next();
      store.remove(oldest);
    }
  }

  private static boolean isTransientServerError(RuntimeException err) {
    return err instanceof AxHubException e && e.status() >= 500;
  }

  public static String schemaCacheKey(String tenantSlug, String appSlug, String table) {
    return tenantSlug + "/" + appSlug + "/" + table;
  }
}
