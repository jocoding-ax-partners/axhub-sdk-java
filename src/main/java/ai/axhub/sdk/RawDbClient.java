package ai.axhub.sdk;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Typed, read-only raw-DB read facade, mirroring the Go SDK's {@code client.Apps.RawDb()}. Reach it
 * via {@code client.apps().rawDb()}.
 *
 * <p>Raw DB is an opt-in physical Postgres surface. This facade is read-only (introspection + row
 * reads); enabling raw DB and writing rows are separate concerns handled by the deployed app's
 * {@code DATABASE_URL}, not this SDK.
 */
public final class RawDbClient {
  private final AxHubClient client;

  RawDbClient(AxHubClient client) {
    this.client = client;
  }

  /**
   * Lists the raw DB tables for an app, with typed column metadata.
   *
   * <p>A successful 2xx call that returns an empty list means the app genuinely has no raw DB
   * tables — either raw DB is not enabled for the app, or it has zero tables. A 4xx authentication
   * or permission failure throws {@link AxHubException}, so an empty list <em>without</em> an
   * exception means "empty", not "auth failed" (resolving the ambiguity the raw map response
   * leaves).
   *
   * @param appId the app id; must be non-blank
   * @return the typed raw DB tables, empty when the app has none
   * @throws AxHubException if {@code appId} is blank (before any HTTP call), or on a backend error
   */
  public List<RawDbTable> tables(String appId) {
    if (appId == null || appId.isBlank()) {
      throw new AxHubException("validation", "required", "appID is required", 0, false);
    }
    Map<String, Object> resp =
        client.data().schemaGetApiV1AppsByAppIDDbTables(Map.of("appID", appId), Map.of(), null);
    List<RawDbTable> tables = new ArrayList<>();
    if (resp.get("tables") instanceof List<?> raw) {
      for (Object table : raw) {
        if (table instanceof Map<?, ?> m) tables.add(parseTable(m));
      }
    }
    return tables;
  }

  /**
   * Reads one page of rows from a raw DB table. Pass {@code null} opts for the backend default page
   * size. {@code perPage}/{@code page} are forwarded as {@code per_page}/{@code page} query params
   * only when positive.
   *
   * @param appId the app id; must be non-blank
   * @param table the raw table name; must be non-blank
   * @param opts optional pagination controls, or {@code null} for backend defaults
   * @throws AxHubException if {@code appId} or {@code table} is blank (before any HTTP call), or on
   *     a backend error
   */
  public RawDbTableRows tableRows(String appId, String table, RawDbTableRowsOptions opts) {
    if (appId == null || appId.isBlank() || table == null || table.isBlank()) {
      throw new AxHubException("validation", "required", "appID and table are required", 0, false);
    }
    Map<String, String> query = new LinkedHashMap<>();
    if (opts != null) {
      if (opts.perPage() > 0) query.put("per_page", Integer.toString(opts.perPage()));
      if (opts.page() > 0) query.put("page", Integer.toString(opts.page()));
    }
    Map<String, Object> resp =
        client
            .data()
            .schemaGetApiV1AppsByAppIDDbTablesByTableRows(
                Map.of("appID", appId, "table", table), query, null);
    return new RawDbTableRows(
        parseRows(resp.get("rows")),
        asInt(resp.get("page")),
        asInt(resp.get("perPage")),
        asBool(resp.get("hasMore")));
  }

  private static RawDbTable parseTable(Map<?, ?> m) {
    List<RawDbColumn> columns = new ArrayList<>();
    if (m.get("columns") instanceof List<?> raw) {
      for (Object col : raw) {
        if (col instanceof Map<?, ?> cm) {
          columns.add(
              new RawDbColumn(asString(cm.get("name")), asString(cm.get("dataType")), asBool(cm.get("nullable"))));
        }
      }
    }
    return new RawDbTable(asString(m.get("name")), asBool(m.get("managed")), columns);
  }

  @SuppressWarnings("unchecked")
  private static List<Map<String, Object>> parseRows(Object raw) {
    List<Map<String, Object>> rows = new ArrayList<>();
    if (raw instanceof List<?> list) {
      for (Object row : list) {
        if (row instanceof Map<?, ?> m) rows.add((Map<String, Object>) m);
      }
    }
    return rows;
  }

  private static String asString(Object v) {
    return v == null ? null : v.toString();
  }

  private static boolean asBool(Object v) {
    return v instanceof Boolean b && b;
  }

  private static int asInt(Object v) {
    return v instanceof Number n ? n.intValue() : 0;
  }
}
