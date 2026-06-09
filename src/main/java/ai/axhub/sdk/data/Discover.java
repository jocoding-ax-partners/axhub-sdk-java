package ai.axhub.sdk.data;

import ai.axhub.sdk.AxHubClient;
import ai.axhub.sdk.AxHubException;
import ai.axhub.sdk.data.Schema.DataTableSchema;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Runtime schema introspection via the table {@code /inspect} endpoint, with an
 * appId-resolution fallback and error normalization (mirrors node discover.ts
 * and the Python port's discover.py).
 *
 * <p>Primary: {@code GET /api/v1/tenants/{t}/apps/{a}/tables/{table}/inspect}.
 * Fallback on 404: resolve appId by scanning {@code GET /api/v1/apps?tenant_slug=...},
 * then {@code GET /api/v1/apps/{appId}/tables/{table}}. Neither endpoint has a
 * generated operation-id, so discover goes through the raw-path transport with
 * {@code camelize=true} (inspect payload is metadata, not user row data).
 */
public final class Discover {
  private Discover() {}

  static final int APP_LOOKUP_PAGE_SIZE = 100;
  static final int APP_LOOKUP_MAX_PAGES = 10;
  static final long APP_LOOKUP_BUDGET_MS = 5_000;

  private static final Set<String> FORBIDDEN_COLUMN_NAMES = Set.of("__proto__", "constructor", "prototype");
  private static final Pattern COLUMN_NAME_RE = Pattern.compile("^[A-Za-z_][A-Za-z0-9_]*$");

  private static String enc(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }

  public static DataTableSchema fetchDiscoveredSchema(AxHubClient client, String tenantSlug, String appSlug, String table) {
    // The appId path (resolve via tenant_slug -> GET /api/v1/apps/{appId}/tables/{table})
    // is the route the `axhub` CLI uses and is verified to work with a data-ring PAT
    // (2026-06). The slug `/inspect` route rejects a slug in the {tenant} path segment
    // on the live backend ("tenant_id 형식이 잘못됐어요", HTTP 400) — and because that
    // is a 400 not a 404, the old slug-first order never reached this working path.
    // So appId is primary; slug inspect is a best-effort fallback for deployments that
    // expose it. The appId error is the meaningful one, so it is what surfaces.
    try {
      return fetchAppIdInspect(client, tenantSlug, appSlug, table);
    } catch (RuntimeException err) {
      try {
        return fetchSlugInspect(client, tenantSlug, appSlug, table);
      } catch (RuntimeException ignored) {
        throw normalizeDiscoverError(err, tenantSlug, appSlug, table);
      }
    }
  }

  private static DataTableSchema fetchSlugInspect(AxHubClient client, String tenantSlug, String appSlug, String table) {
    String path = "/api/v1/tenants/" + enc(tenantSlug) + "/apps/" + enc(appSlug) + "/tables/" + enc(table) + "/inspect";
    Map<String, Object> raw = client.requestRaw("GET", path, null, null, true);
    return schemaFromInspectResult(table, raw);
  }

  private static DataTableSchema fetchAppIdInspect(AxHubClient client, String tenantSlug, String appSlug, String table) {
    String appId = resolveAppId(client, tenantSlug, appSlug);
    if (appId == null || appId.isEmpty()) {
      throw new DataErrors.TableNotFoundError("Dynamic data table '" + table + "' was not found");
    }
    String path = "/api/v1/apps/" + enc(appId) + "/tables/" + enc(table);
    Map<String, Object> raw = client.requestRaw("GET", path, null, null, true);
    return schemaFromInspectResult(table, raw);
  }

  @SuppressWarnings("unchecked")
  private static String resolveAppId(AxHubClient client, String tenantSlug, String appSlug) {
    long startedAt = System.nanoTime() / 1_000_000L;
    String cursor = null;
    for (int page = 0; page < APP_LOOKUP_MAX_PAGES; page++) {
      if (System.nanoTime() / 1_000_000L - startedAt > APP_LOOKUP_BUDGET_MS) {
        throw new DataErrors.IntrospectFailedError(
            "app lookup budget exceeded (" + APP_LOOKUP_BUDGET_MS + "ms) while searching for slug '"
                + appSlug + "' in tenant '" + tenantSlug + "'");
      }
      Map<String, Object> query = new LinkedHashMap<>();
      query.put("tenant_slug", tenantSlug);
      query.put("limit", String.valueOf(APP_LOOKUP_PAGE_SIZE));
      if (cursor != null) query.put("cursor", cursor);
      Map<String, Object> raw = client.requestRaw("GET", "/api/v1/apps", query, null, true);
      List<Object> items = raw.get("items") instanceof List<?> l ? (List<Object>) l : List.of();
      for (Object item : items) {
        Map<String, Object> app = (Map<String, Object>) item;
        if (appSlug.equals(app.get("slug")) && app.get("id") instanceof String id) {
          return id;
        }
      }
      // Empty page on the first request means the tenant truly has no apps.
      if (page == 0 && items.isEmpty()) return null;
      Object nextCursor = raw.get("nextCursor"); // camelized from next_cursor
      if (nextCursor == null) nextCursor = raw.get("next_cursor");
      if (!(nextCursor instanceof String nc) || nc.isEmpty()) return null;
      cursor = nc;
    }
    throw new DataErrors.ScanLimitExceededError(
        "App lookup exceeded " + APP_LOOKUP_MAX_PAGES + " pages x " + APP_LOOKUP_PAGE_SIZE
            + " apps without finding slug '" + appSlug + "'");
  }

  private static RuntimeException normalizeDiscoverError(RuntimeException err, String tenantSlug, String appSlug, String table) {
    if (err instanceof DataErrors.TableNotFoundError
        || err instanceof DataErrors.IntrospectFailedError
        || err instanceof DataErrors.ScanLimitExceededError) {
      return err;
    }
    if (isNotFound(err)) {
      String requestId = err instanceof AxHubException e ? e.requestId() : null;
      return new DataErrors.TableNotFoundError("Dynamic data table '" + table + "' was not found", requestId);
    }
    if (err instanceof AxHubException e && e.status() >= 500) {
      return new DataErrors.IntrospectFailedError(
          "Failed to introspect dynamic data table '" + table + "'", e.status(), e.retryable(), e.requestId());
    }
    return err;
  }

  @SuppressWarnings("unchecked")
  public static DataTableSchema schemaFromInspectResult(String table, Map<String, Object> raw) {
    if (raw == null) raw = Map.of();
    List<Object> columns = raw.get("columns") instanceof List<?> l ? (List<Object>) l : List.of();
    Map<String, Object> shape = new LinkedHashMap<>();
    for (Object c : columns) {
      Map<String, Object> column = (Map<String, Object>) c;
      Object name = column.get("name");
      if (FORBIDDEN_COLUMN_NAMES.contains(name)) continue;
      if (!(name instanceof String s) || !COLUMN_NAME_RE.matcher(s).matches()) continue;
      shape.put(s, columnTypeToDef(column.get("type")));
    }
    // camelize=true turns table_name -> tableName; keep both forms defensively.
    Object tableName = firstNonNull(raw.get("tableName"), raw.get("table_name"), raw.get("name"), table);
    return Schema.defineSchema(String.valueOf(tableName), shape);
  }

  private static Object firstNonNull(Object... values) {
    for (Object v : values) {
      if (v != null) return v;
    }
    return null;
  }

  private static String columnTypeToDef(Object type) {
    String t = type == null ? "" : String.valueOf(type);
    return switch (t) {
      case "uuid" -> "uuid";
      case "int", "integer", "bigint" -> "integer";
      case "float", "numeric", "double precision", "real" -> "number";
      case "bool", "boolean" -> "boolean";
      case "timestamp", "timestamptz", "timestamp with time zone" -> "timestamp";
      case "json", "jsonb" -> "json";
      default -> "string"; // text / varchar / character varying / unknown
    };
  }

  private static boolean isNotFound(RuntimeException err) {
    if (err instanceof DataErrors.TableNotFoundError) return true;
    return err instanceof AxHubException e && e.status() == 404;
  }
}
