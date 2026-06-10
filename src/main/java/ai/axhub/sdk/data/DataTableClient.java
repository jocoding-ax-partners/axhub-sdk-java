package ai.axhub.sdk.data;

import ai.axhub.sdk.AxHubClient;
import ai.axhub.sdk.data.Pagination.ListAllItem;
import ai.axhub.sdk.data.Pagination.PaginatedList;
import ai.axhub.sdk.data.Schema.DataTableSchema;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Client bound to one {@code {tenant}/{app}/{table}} with CRUD + offset
 * pagination (mirrors node DataTableClient and the Python port's
 * DataTableClient).
 *
 * <p>Wire paths (EXACTLY as node, via the raw-path transport so row bodies and
 * the list envelope are returned verbatim, no snake-&gt;camel rewriting):
 * <pre>
 *   list / insert         GET|POST          /data/{tenant}/{app}/{table}
 *   get / update / delete  GET|PATCH|DELETE  /data/{tenant}/{app}/{table}/{id}
 *   count                  GET               /data/{tenant}/{app}/{table}/_count
 * </pre>
 *
 * <p>Sync methods are the canonical core; the {@code …Async} wrappers are thin
 * {@link CompletableFuture} adapters, which keeps the core cleanly wrappable by
 * a Kotlin coroutine/Flow layer.
 */
public final class DataTableClient {
  private final AxHubClient client;
  private final String tenantSlug;
  private final String appSlug;
  private final String tableName;
  private final DataTableSchema schema;

  public DataTableClient(AxHubClient client, String tenantSlug, String appSlug, String tableName, DataTableSchema schema) {
    this.client = client;
    this.tenantSlug = tenantSlug;
    this.appSlug = appSlug;
    this.tableName = tableName;
    this.schema = schema;
  }

  public DataTableSchema schema() {
    return schema;
  }

  private static String enc(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }

  private String path() {
    return "/data/" + enc(tenantSlug) + "/" + enc(appSlug) + "/" + enc(tableName);
  }

  private String path(String rowId) {
    return path() + "/" + enc(rowId);
  }

  // --------------------------------- list ----------------------------------

  public PaginatedList list() {
    return list(ListOptions.create());
  }

  @SuppressWarnings("unchecked")
  public PaginatedList list(ListOptions opts) {
    validateSelect(opts.select);
    rejectLegacyPageOptions(opts);
    int resolvedPage = resolveOffsetPage(opts.cursor, opts.page);
    Integer perPage = clampPerPage(opts.pageSize != null ? opts.pageSize : opts.limit);
    Map<String, Object> query = new LinkedHashMap<>(WhereSerializer.serializeWhere(opts.where));
    if (perPage != null) query.put("per_page", String.valueOf(perPage));
    if (resolvedPage != 1) query.put("page", String.valueOf(resolvedPage));
    String sort = Pagination.serializeOrderBy(opts.orderBy);
    if (sort != null && !sort.isEmpty()) query.put("sort", sort); // mirror node truthiness-skip (empty sort omitted)
    String select = Projection.serializeSelect(opts.select);
    if (select != null) query.put("_select", select);

    Map<String, Object> raw = mapWhereRequired("list", () -> client.requestRaw("GET", path(), query, null, false));
    List<?> rawItems = raw.get("items") instanceof List<?> l ? l : List.of();
    List<Map<String, Object>> items = Projection.projectRows(rawItems, opts.select);
    // NOTE: mirrors node behavior — current_page falls back to the requested
    // page, has_next reads the backend `has_more` flag verbatim, has_prev is
    // derived client-side from the page number (see gap-matrix S7-S9).
    int currentPage = raw.get("page") instanceof Number n ? n.intValue() : resolvedPage;
    boolean hasNext = Boolean.TRUE.equals(raw.get("has_more"));
    boolean hasPrev = currentPage > 1;
    return new PaginatedList(
        items,
        hasNext ? String.valueOf(currentPage + 1) : null,
        hasPrev ? String.valueOf(currentPage - 1) : null,
        hasNext,
        hasPrev,
        null,
        false);
  }

  public CompletableFuture<PaginatedList> listAsync(ListOptions opts) {
    return CompletableFuture.supplyAsync(() -> list(opts));
  }

  /** Lazily drive every page to exhaustion, emitting items + drift markers. */
  public Iterator<ListAllItem> listAll(ListOptions opts) {
    ListOptions base = opts == null ? ListOptions.create() : opts;
    Integer pageSize = base.pageSize != null ? base.pageSize : base.limit;
    return Pagination.listAll(req -> {
      ListOptions perPage = base.copy();
      if (req.cursor() != null) perPage.cursor = req.cursor();
      if (req.pageSize() != null) perPage.pageSize = req.pageSize();
      return list(perPage);
    }, pageSize);
  }

  /** Convenience: collect {@code listAll} item values into a list (drift markers dropped). */
  public List<Map<String, Object>> listAllItems(ListOptions opts) {
    List<Map<String, Object>> out = new ArrayList<>();
    Iterator<ListAllItem> it = listAll(opts);
    while (it.hasNext()) {
      ListAllItem item = it.next();
      if ("item".equals(item.type)) out.add(item.value);
    }
    return out;
  }

  // --------------------------------- count ---------------------------------

  public int count() {
    return count(null);
  }

  public int count(Map<String, Object> where) {
    Map<String, Object> raw = mapWhereRequired("count", () -> client.requestRaw("GET", path() + "/_count", WhereSerializer.serializeWhere(where), null, false));
    Object n = raw.get("count");
    return n instanceof Number num ? num.intValue() : 0;
  }

  public CompletableFuture<Integer> countAsync(Map<String, Object> where) {
    return CompletableFuture.supplyAsync(() -> count(where));
  }

  // ---------------------------------- get ----------------------------------

  public Map<String, Object> get(String id) {
    return get(id, null);
  }

  public Map<String, Object> get(String id, List<String> select) {
    validateSelect(select);
    String serializedSelect = Projection.serializeSelect(select);
    Map<String, Object> query = serializedSelect == null ? null : Map.of("_select", serializedSelect);
    Map<String, Object> row = client.requestRaw("GET", path(id), query, null, false);
    return Projection.projectRow(row, select);
  }

  public CompletableFuture<Map<String, Object>> getAsync(String id, List<String> select) {
    return CompletableFuture.supplyAsync(() -> get(id, select));
  }

  // -------------------------------- insert ---------------------------------

  public Map<String, Object> insert(Map<String, Object> row) {
    SchemaValidation.runSchemaValidation(schema, row, "insert");
    return client.requestRaw("POST", path(), null, row, false);
  }

  public CompletableFuture<Map<String, Object>> insertAsync(Map<String, Object> row) {
    return CompletableFuture.supplyAsync(() -> insert(row));
  }

  public Map<String, Object> insertMany(List<Map<String, Object>> rows) {
    for (Map<String, Object> row : rows) SchemaValidation.runSchemaValidation(schema, row, "insert");
    // NOTE: mirrors node behavior — no bulk endpoint exists, so insertMany
    // loops single inserts and returns {items, count} (see gap-matrix).
    List<Map<String, Object>> items = new ArrayList<>(rows.size());
    for (Map<String, Object> row : rows) items.add(insert(row));
    Map<String, Object> out = new LinkedHashMap<>();
    out.put("items", items);
    out.put("count", items.size());
    return out;
  }

  public CompletableFuture<Map<String, Object>> insertManyAsync(List<Map<String, Object>> rows) {
    return CompletableFuture.supplyAsync(() -> insertMany(rows));
  }

  // -------------------------------- update ---------------------------------

  public Map<String, Object> update(String id, Map<String, Object> patch) {
    SchemaValidation.runSchemaValidation(schema, patch, "update");
    return client.requestRaw("PATCH", path(id), null, patch, false);
  }

  public CompletableFuture<Map<String, Object>> updateAsync(String id, Map<String, Object> patch) {
    return CompletableFuture.supplyAsync(() -> update(id, patch));
  }

  // -------------------------------- delete ---------------------------------

  public void delete(String id) {
    client.requestRaw("DELETE", path(id), null, null, false);
  }

  public CompletableFuture<Void> deleteAsync(String id) {
    return CompletableFuture.runAsync(() -> delete(id));
  }

  // ------------------------------- internals -------------------------------

  private void validateSelect(List<String> select) {
    Projection.validateSelectColumns(schema, select);
  }

  /**
   * The AxHub data ring rejects an unfiltered list/count with HTTP 400
   * ("최소 1개의 WHERE 필터가 필요해요") on NON-owner-scoped tables, but ACCEPTS
   * unfiltered calls on owner-scoped tables (rows auto-scope to the caller) —
   * both confirmed live 2026-06. A client pre-check cannot tell them apart
   * (0.3.0 regression), so the request goes through and only the backend 400 is
   * normalized into the same actionable error (mirrors node/python/go/ruby).
   */
  private static <T> T mapWhereRequired(String op, java.util.function.Supplier<T> run) {
    try {
      return run.get();
    } catch (ai.axhub.sdk.AxHubException e) {
      if ("required".equals(e.code()) && e.status() == 400) {
        throw new DataErrors.ValidationError(
            "AxHub data " + op + " requires at least one WHERE filter on this table "
                + "(the backend rejects unfiltered scans on non-owner-scoped tables). Pass `where: ...`.",
            "where_required");
      }
      throw e;
    }
  }

  private void rejectLegacyPageOptions(ListOptions opts) {
    if (opts.after != null || opts.before != null || opts.direction != null) {
      throw new DataErrors.LegacyCursorError(
          "after/before keyset cursors are not supported by the live AX Hub data API; use cursor/page numeric offset pagination");
    }
  }

  private int resolveOffsetPage(String cursor, Integer page) {
    if (cursor != null) {
      validatePlainCursor(cursor);
      return Integer.parseInt(cursor);
    }
    if (page == null) return 1;
    if (page < 1) {
      throw new DataErrors.InvalidCursorError("page must be a positive integer");
    }
    return page;
  }

  private void validatePlainCursor(String cursor) {
    if (cursor.length() > Pagination.MAX_CURSOR_TOKEN_LENGTH) {
      throw new DataErrors.InvalidCursorError(
          "Cursor token exceeds maximum size (" + Pagination.MAX_CURSOR_TOKEN_LENGTH + " chars)");
    }
    if (cursor.startsWith("v1:")) {
      throw new DataErrors.LegacyCursorError(
          "Legacy v1: cursor token is not compatible with AX Hub offset-only pagination; restart pagination without cursor");
    }
    if (Pagination.isV2Cursor(cursor)) {
      throw new DataErrors.LegacyCursorError(
          "v2 keyset cursors are not supported by the live AX Hub data API; restart pagination and use the numeric cursor returned by list()");
    }
    int parsed;
    try {
      parsed = Integer.parseInt(cursor);
    } catch (NumberFormatException e) {
      throw new DataErrors.InvalidCursorError("Plain cursor must be a positive integer page or a v2: keyset token");
    }
    if (parsed < 1) {
      throw new DataErrors.InvalidCursorError("Plain cursor must be a positive integer page or a v2: keyset token");
    }
  }

  /** Clamp a page size into the backend-accepted 1..100 range (null passes through). */
  public static Integer clampPerPage(Integer value) {
    if (value == null) return null;
    return Math.min(100, Math.max(1, value));
  }
}
