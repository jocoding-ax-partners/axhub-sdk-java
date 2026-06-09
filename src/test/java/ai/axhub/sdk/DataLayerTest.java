package ai.axhub.sdk;

import ai.axhub.sdk.data.AppDataFactory;
import ai.axhub.sdk.data.DataErrors;
import ai.axhub.sdk.data.DataTableClient;
import ai.axhub.sdk.data.ListOptions;
import ai.axhub.sdk.data.Ops;
import ai.axhub.sdk.data.Pagination;
import ai.axhub.sdk.data.Pagination.ListAllItem;
import ai.axhub.sdk.data.Pagination.PageRequest;
import ai.axhub.sdk.data.Pagination.PaginatedList;
import ai.axhub.sdk.data.Projection;
import ai.axhub.sdk.data.Schema;
import ai.axhub.sdk.data.Schema.DataTableSchema;
import ai.axhub.sdk.data.SchemaCache;
import ai.axhub.sdk.data.WhereSerializer;
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * Unit + wire tests for the ergonomic data layer.
 *
 * <p>These mirror the node data layer's behavior and the Python port's 38
 * tests in {@code test_data_layer.py}. The Java conformance runner only
 * exercises the operation-id route-table surface (via {@code sdk.operation}),
 * NOT this fluent {@code .table().list()} layer — so these are the real proof
 * of the ergonomic port (see DoD #3).
 *
 * <p>This follows the project's existing hand-rolled test idiom
 * ({@code main()} + {@code require()} + {@code com.sun.net.httpserver}) rather
 * than JUnit: the build deliberately disables the {@code test} task and proves
 * everything through {@code JavaExec} runners wired into {@code check}. Each
 * case is tallied so the pass/fail count is explicit.
 */
public final class DataLayerTest {
  private static final AtomicInteger PASSED = new AtomicInteger();
  private static final List<String> FAILURES = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    run();
  }

  /** Runs every case, prints the tally, and throws if any failed (so it gates {@code check}). */
  static void run() throws Exception {
    runCases();
    System.out.println("DataLayerTest: " + PASSED.get() + " passed, " + FAILURES.size() + " failed");
    if (!FAILURES.isEmpty()) {
      FAILURES.forEach(f -> System.out.println("  FAIL: " + f));
      throw new AssertionError(FAILURES.size() + " data-layer test(s) failed");
    }
  }

  static void runCases() throws Exception {
    // --- pure units: where serializer ---
    test("whereAtomAndAndAndIn", DataLayerTest::testWhereAtomAndAndAndIn);
    test("whereBoolAndNullStringifyLikeJs", DataLayerTest::testWhereBoolAndNullStringify);
    test("whereRepeatedColumnCollapsesToList", DataLayerTest::testRepeatedColumnCollapses);
    test("whereInCommaGuard", DataLayerTest::testInCommaGuard);
    test("whereUnsupportedFiltersRejected", DataLayerTest::testUnsupportedFiltersRejected);
    test("whereNestedAndIsNotPushable", DataLayerTest::testNestedAndNotPushable);
    // --- order by ---
    test("orderByStringFormAppendsIdTiebreaker", DataLayerTest::testOrderByStringForm);
    test("orderByFieldListForm", DataLayerTest::testOrderByFieldListForm);
    test("orderByEmptyIsNull", DataLayerTest::testOrderByEmptyIsNull);
    // --- clamp per page ---
    test("clampPerPage1To100", DataLayerTest::testClampPerPage);
    // --- select ---
    test("selectSerialize", DataLayerTest::testSelectSerialize);
    test("selectEmptyRejected", DataLayerTest::testSelectEmptyRejected);
    test("selectUnknownColumnRejectedWithSchema", DataLayerTest::testSelectUnknownColumnRejected);
    test("selectProjectRowNarrows", DataLayerTest::testProjectRowNarrows);
    // --- cursor rejection (wire) ---
    testServer("cursorAfterBeforeDirectionRejected", DataLayerTest::testAfterBeforeDirectionRejected);
    testServer("cursorV1AndV2Rejected", DataLayerTest::testV1V2CursorRejected);
    testServer("cursorNonIntegerRejected", DataLayerTest::testNonIntegerCursorRejected);
    testServer("cursorOversizedRejected", DataLayerTest::testOversizedCursorRejected);
    testServer("cursorBadPageRejected", DataLayerTest::testBadPageRejected);
    test("isV2CursorHelper", DataLayerTest::testIsV2CursorHelper);
    // --- where-required mass-scan guard (Fix A) ---
    testServer("listFilterlessRejectedBeforeNetwork", DataLayerTest::testListFilterlessRejected);
    testServer("countFilterlessRejectedBeforeNetwork", DataLayerTest::testCountFilterlessRejected);
    // --- list wire ---
    testServer("listQueryAndEnvelope", DataLayerTest::testListQueryAndEnvelope);
    testServer("listRowDataVerbatimNoCamelize", DataLayerTest::testRowDataVerbatim);
    testServer("listPage1OmitsPageQuery", DataLayerTest::testPage1OmitsPageQuery);
    testServer("listSelectProjectsClientSide", DataLayerTest::testSelectProjectsClientSide);
    testServer("listRepeatedColumnEmitsRepeatedParams", DataLayerTest::testRepeatedColumnWire);
    // --- crud wire ---
    testServer("crudCount", DataLayerTest::testCount);
    testServer("crudGet", DataLayerTest::testGet);
    testServer("crudInsert", DataLayerTest::testInsert);
    testServer("crudInsertManyLoops", DataLayerTest::testInsertManyLoops);
    testServer("crudUpdate", DataLayerTest::testUpdate);
    testServer("crudDelete", DataLayerTest::testDelete);
    // --- list_all drift ---
    test("listAllDrivesPagesAndEmitsDrift", DataLayerTest::testListAllDrift);
    // --- discover (wire) ---
    testServer("discoverAppIdPathPrimary", DataLayerTest::testDiscoverAppIdPathPrimary);
    testServer("discoverCachesAcrossChains", DataLayerTest::testDiscoverCachesAcrossChains);
    testServer("discover404BecomesTableNotFound", DataLayerTest::testDiscover404BecomesTableNotFound);
    // --- schema cache ---
    test("schemaCacheGetOrSetCaches", DataLayerTest::testSchemaCacheGetOrSet);
    test("schemaCacheLruEviction", DataLayerTest::testSchemaCacheLruEviction);
    // --- like guards ---
    test("likeContainsEscapesWildcards", DataLayerTest::testLikeContainsEscapes);
    test("likeRawRedosGuard", DataLayerTest::testLikeRawRedosGuard);
  }

  // ============================ pure units =================================

  static void testWhereAtomAndAndAndIn() {
    requireEq(Map.of("status", "eq.paid"), WhereSerializer.serializeWhere(Ops.where("status").eq("paid")));
    requireEq(Map.of("total", "gte.10", "status", "ne.void"),
        WhereSerializer.serializeWhere(Ops.and(Ops.where("total").gte(10), Ops.where("status").ne("void"))));
    requireEq(Map.of("id", "in.a,b"), WhereSerializer.serializeWhere(Ops.where("id").in(List.of("a", "b"))));
  }

  static void testWhereBoolAndNullStringify() {
    requireEq(Map.of("active", "eq.true"), WhereSerializer.serializeWhere(Ops.where("active").eq(true)));
    Map<String, Object> nullExpr = new LinkedHashMap<>();
    nullExpr.put("op", "eq");
    nullExpr.put("column", "deleted");
    nullExpr.put("value", null);
    requireEq(Map.of("deleted", "eq.null"), WhereSerializer.serializeWhere(nullExpr));
  }

  static void testRepeatedColumnCollapses() {
    Map<String, Object> out = WhereSerializer.serializeWhere(Ops.and(Ops.where("tag").eq("a"), Ops.where("tag").eq("b")));
    requireEq(Map.of("tag", List.of("eq.a", "eq.b")), out);
  }

  static void testInCommaGuard() {
    DataErrors.ValidationError e = expect(DataErrors.ValidationError.class,
        () -> WhereSerializer.serializeWhere(Ops.where("name").in(List.of("a,b"))));
    require("filter_in_comma".equals(e.code()), "in-comma code drift " + e.code());
  }

  static void testUnsupportedFiltersRejected() {
    Map<String, Object> rawExpr = new LinkedHashMap<>();
    rawExpr.put("op", "raw");
    rawExpr.put("sql", "1=1");
    List<Map<String, Object>> exprs = List.of(
        Ops.or(Ops.where("a").eq(1)),
        Ops.not(Ops.where("a").eq(1)),
        rawExpr);
    for (Map<String, Object> expr : exprs) {
      DataErrors.ValidationError e = expect(DataErrors.ValidationError.class, () -> WhereSerializer.serializeWhere(expr));
      require("unsupported_filter".equals(e.code()), "unsupported_filter code drift " + e.code());
    }
  }

  static void testNestedAndNotPushable() {
    DataErrors.ValidationError e = expect(DataErrors.ValidationError.class,
        () -> WhereSerializer.serializeWhere(Ops.and(Ops.and(Ops.where("a").eq(1)))));
    require("unsupported_filter".equals(e.code()), "nested-and code drift " + e.code());
  }

  static void testOrderByStringForm() {
    require("-total,id".equals(Pagination.serializeOrderBy("-total")), "string order-by drift");
    require("name,id".equals(Pagination.serializeOrderBy("name")), "string order-by drift");
  }

  static void testOrderByFieldListForm() {
    require("-total,id".equals(Pagination.serializeOrderBy(List.of(new Pagination.OrderField("total", "desc")))),
        "field-list order-by drift");
  }

  static void testOrderByEmptyIsNull() {
    require(Pagination.serializeOrderBy(null) == null, "empty order-by should be null");
  }

  static void testClampPerPage() {
    require(Integer.valueOf(1).equals(DataTableClient.clampPerPage(0)), "clamp 0 -> 1");
    require(Integer.valueOf(50).equals(DataTableClient.clampPerPage(50)), "clamp 50");
    require(Integer.valueOf(100).equals(DataTableClient.clampPerPage(1000)), "clamp 1000 -> 100");
    require(Integer.valueOf(1).equals(DataTableClient.clampPerPage(-5)), "clamp -5 -> 1");
    require(DataTableClient.clampPerPage(null) == null, "clamp null -> null");
  }

  static void testSelectSerialize() {
    require("id,total".equals(Projection.serializeSelect(List.of("id", "total"))), "serialize select drift");
    require(Projection.serializeSelect(null) == null, "serialize null select");
  }

  static void testSelectEmptyRejected() {
    DataErrors.ValidationError e = expect(DataErrors.ValidationError.class,
        () -> Projection.validateSelectColumns(null, List.of()));
    require("select_empty".equals(e.code()), "select_empty code drift " + e.code());
  }

  static void testSelectUnknownColumnRejected() {
    DataTableSchema schema = Schema.defineSchema("orders", Map.of("id", "uuid", "total", "number"));
    DataErrors.ValidationError e = expect(DataErrors.ValidationError.class,
        () -> Projection.validateSelectColumns(schema, List.of("id", "nope")));
    require("select_unknown_column".equals(e.code()), "unknown column code drift " + e.code());
  }

  static void testProjectRowNarrows() {
    Map<String, Object> row = new LinkedHashMap<>();
    row.put("id", "x");
    row.put("total", 5);
    row.put("extra", 1);
    requireEq(Map.of("id", "x"), Projection.projectRow(row, List.of("id")));
  }

  static void testIsV2CursorHelper() {
    require(Pagination.isV2Cursor("v2:x"), "v2 cursor should be detected");
    require(!Pagination.isV2Cursor("3"), "plain int is not v2");
  }

  static void testListAllDrift() {
    List<PaginatedList> pages = List.of(
        new PaginatedList(List.of(Map.of("id", 1)), "2", null, true, false, 2, false),
        new PaginatedList(List.of(Map.of("id", 2)), null, null, false, false, 3, false));
    AtomicInteger i = new AtomicInteger();
    Function<PageRequest, PaginatedList> fetcher = req -> pages.get(i.getAndIncrement());
    Iterator<ListAllItem> it = Pagination.listAll(fetcher, null);
    List<String> kinds = new ArrayList<>();
    while (it.hasNext()) {
      ListAllItem item = it.next();
      kinds.add("item".equals(item.type) ? "item:" + item.value.get("id") : "drift:" + item.addedSince);
    }
    requireEq(List.of("item:1", "drift:1", "item:2"), kinds);
  }

  static void testSchemaCacheGetOrSet() {
    SchemaCache cache = new SchemaCache();
    AtomicInteger calls = new AtomicInteger();
    java.util.function.Supplier<DataTableSchema> loader = () -> {
      calls.incrementAndGet();
      return Schema.defineSchema("orders", Map.of("id", "uuid"));
    };
    cache.getOrSet("k", loader, null, null);
    cache.getOrSet("k", loader, null, null);
    require(calls.get() == 1, "cache should memoize, calls=" + calls.get());
    cache.invalidate("k");
    cache.getOrSet("k", loader, null, null);
    require(calls.get() == 2, "invalidate should force reload, calls=" + calls.get());
  }

  static void testSchemaCacheLruEviction() {
    SchemaCache cache = new SchemaCache(2, null, null);
    for (String k : List.of("a", "b", "c")) cache.set(k, Schema.defineSchema(k, Map.of("id", "uuid")), null);
    require(cache.get("a") == null, "a should be evicted");
    require(cache.get("c") != null, "c should survive");
  }

  static void testLikeContainsEscapes() {
    Map<String, Object> expr = Ops.where("name").like.contains("50%_off");
    require("%50\\%\\_off%".equals(expr.get("value")), "like contains escape drift: " + expr.get("value"));
  }

  static void testLikeRawRedosGuard() {
    expect(DataErrors.ValidationError.class, () -> Ops.where("name").like.raw("%%%%x"));
  }

  // =========================== wire tests ==================================

  static void testAfterBeforeDirectionRejected(MockServer s) {
    expect(DataErrors.LegacyCursorError.class, () -> table(s).list(ListOptions.create().after("x")));
    expect(DataErrors.LegacyCursorError.class, () -> table(s).list(ListOptions.create().before("x")));
    expect(DataErrors.LegacyCursorError.class, () -> table(s).list(ListOptions.create().direction("forward")));
  }

  static void testV1V2CursorRejected(MockServer s) {
    expect(DataErrors.LegacyCursorError.class, () -> table(s).list(ListOptions.create().cursor("v1:abc")));
    expect(DataErrors.LegacyCursorError.class, () -> table(s).list(ListOptions.create().cursor("v2:abc")));
  }

  static void testNonIntegerCursorRejected(MockServer s) {
    expect(DataErrors.InvalidCursorError.class, () -> table(s).list(ListOptions.create().cursor("abc")));
    expect(DataErrors.InvalidCursorError.class, () -> table(s).list(ListOptions.create().cursor("0")));
  }

  static void testOversizedCursorRejected(MockServer s) {
    expect(DataErrors.InvalidCursorError.class, () -> table(s).list(ListOptions.create().cursor("1".repeat(5000))));
  }

  static void testBadPageRejected(MockServer s) {
    expect(DataErrors.InvalidCursorError.class, () -> table(s).list(ListOptions.create().page(0)));
  }

  static void testListFilterlessRejected(MockServer s) {
    // The backend 400s an unfiltered scan; the SDK fails fast BEFORE any HTTP call.
    DataErrors.ValidationError e = expect(DataErrors.ValidationError.class, () -> table(s).list());
    require("where_required".equals(e.code()), "where_required code drift " + e.code());
    require(s.path == null, "filterless list must not hit the network, but server saw " + s.path);
  }

  static void testCountFilterlessRejected(MockServer s) {
    DataErrors.ValidationError e = expect(DataErrors.ValidationError.class, () -> table(s).count());
    require("where_required".equals(e.code()), "where_required code drift " + e.code());
    require(s.path == null, "filterless count must not hit the network, but server saw " + s.path);
  }

  static void testListQueryAndEnvelope(MockServer s) {
    s.setResponse(200, "{\"items\":[{\"id\":\"1\",\"created_at\":\"t\"}],\"page\":2,\"per_page\":10,\"has_more\":true}");
    PaginatedList result = table(s).list(ListOptions.create()
        .where(Ops.where("status").eq("paid"))
        .orderBy("-total")
        .select("id", "created_at")
        .page(2)
        .pageSize(10));
    require("GET".equals(s.method), "wrong method " + s.method);
    require("/data/acme/crm/orders".equals(s.path), "wrong path " + s.path);
    Map<String, String> q = s.query();
    require("eq.paid".equals(q.get("status")), "status query drift " + q);
    require("10".equals(q.get("per_page")), "per_page drift " + q);
    require("2".equals(q.get("page")), "page drift " + q);
    require("-total,id".equals(q.get("sort")), "sort drift " + q);
    require("id,created_at".equals(q.get("_select")), "_select drift " + q);
    require("pat_x".equals(s.headers.get("x-api-key")), "api key header drift " + s.headers.get("x-api-key"));
    require("3".equals(result.nextCursor), "next cursor drift " + result.nextCursor);
    require("1".equals(result.firstCursor), "first cursor drift " + result.firstCursor);
    require(Boolean.TRUE.equals(result.hasNext), "hasNext drift");
    require(Boolean.TRUE.equals(result.hasPrev), "hasPrev drift");
    require(Boolean.FALSE.equals(result.totalIsExact), "totalIsExact drift");
  }

  static void testRowDataVerbatim(MockServer s) {
    s.setResponse(200, "{\"items\":[{\"id\":\"1\",\"created_at\":\"2020\",\"is_active\":true}],\"has_more\":false}");
    PaginatedList result = table(s).list(ListOptions.create().where(Ops.where("status").eq("paid")));
    Map<String, Object> expected = new LinkedHashMap<>();
    expected.put("id", "1");
    expected.put("created_at", "2020");
    expected.put("is_active", true);
    requireEq(expected, result.items.get(0));
    require(result.nextCursor == null, "no next cursor expected");
  }

  static void testPage1OmitsPageQuery(MockServer s) {
    s.setResponse(200, "{\"items\":[],\"has_more\":false}");
    table(s).list(ListOptions.create().where(Ops.where("status").eq("paid")).page(1));
    require(!s.query().containsKey("page"), "page=1 must be omitted, query=" + s.query());
  }

  static void testSelectProjectsClientSide(MockServer s) {
    s.setResponse(200, "{\"items\":[{\"id\":\"1\",\"total\":9,\"secret\":\"x\"}],\"has_more\":false}");
    PaginatedList result = table(s).list(ListOptions.create().where(Ops.where("status").eq("paid")).select("id", "total"));
    Map<String, Object> expected = new LinkedHashMap<>();
    expected.put("id", "1");
    expected.put("total", 9.0); // gson untyped numbers -> Double
    requireEq(expected, result.items.get(0));
  }

  static void testRepeatedColumnWire(MockServer s) {
    // The bespoke Java requestRaw encoder must expand List values into REPEATED
    // query params (Python relied on urlencode(doseq=True)). Assert on the raw
    // query string directly — MockServer.query() collapses duplicate keys.
    s.setResponse(200, "{\"items\":[],\"has_more\":false}");
    table(s).list(ListOptions.create().where(Ops.and(Ops.where("tag").eq("a"), Ops.where("tag").eq("b"))));
    require(s.rawQuery != null && s.rawQuery.contains("tag=eq.a") && s.rawQuery.contains("tag=eq.b"),
        "repeated tag params missing: " + s.rawQuery);
  }

  static void testCount(MockServer s) {
    s.setResponse(200, "{\"count\":42}");
    int n = table(s).count(Ops.where("status").eq("paid"));
    require(n == 42, "count drift " + n);
    require("/data/acme/crm/orders/_count".equals(s.path), "count path drift " + s.path);
    require("eq.paid".equals(s.query().get("status")), "count query drift " + s.query());
  }

  static void testGet(MockServer s) {
    s.setResponse(200, "{\"id\":\"abc\",\"total\":5}");
    Map<String, Object> row = table(s).get("abc", List.of("id", "total"));
    Map<String, Object> expected = new LinkedHashMap<>();
    expected.put("id", "abc");
    expected.put("total", 5.0);
    requireEq(expected, row);
    require("GET".equals(s.method), "get method drift");
    require("/data/acme/crm/orders/abc".equals(s.path), "get path drift " + s.path);
    require("id,total".equals(s.query().get("_select")), "get _select drift " + s.query());
  }

  static void testInsert(MockServer s) {
    s.setResponse(200, "{\"id\":\"new\",\"total\":7}");
    Map<String, Object> out = table(s).insert(Map.of("total", 7));
    require("new".equals(out.get("id")), "insert id drift " + out);
    require("POST".equals(s.method), "insert method drift");
    require("/data/acme/crm/orders".equals(s.path), "insert path drift " + s.path);
    require(s.body != null && s.body.contains("\"total\":7"), "insert body drift " + s.body);
  }

  static void testInsertManyLoops(MockServer s) {
    s.setResponse(200, "{\"id\":\"x\"}");
    Map<String, Object> out = table(s).insertMany(List.of(Map.of("a", 1), Map.of("a", 2)));
    require(Integer.valueOf(2).equals(out.get("count")), "insertMany count drift " + out.get("count"));
    require(((List<?>) out.get("items")).size() == 2, "insertMany items drift");
  }

  static void testUpdate(MockServer s) {
    s.setResponse(200, "{\"id\":\"abc\",\"total\":9}");
    Map<String, Object> out = table(s).update("abc", Map.of("total", 9));
    require("PATCH".equals(s.method), "update method drift " + s.method);
    require("/data/acme/crm/orders/abc".equals(s.path), "update path drift " + s.path);
    require("abc".equals(out.get("id")), "update result drift " + out);
  }

  static void testDelete(MockServer s) {
    s.setResponse(204, "{}");
    table(s).delete("abc");
    require("DELETE".equals(s.method), "delete method drift " + s.method);
    require("/data/acme/crm/orders/abc".equals(s.path), "delete path drift " + s.path);
  }

  static void testDiscoverAppIdPathPrimary(MockServer s) {
    // Fix B: appId path is PRIMARY (slug-inspect is a best-effort fallback). The
    // combined body satisfies BOTH the apps-lookup (reads `items`, matches slug
    // crm -> app_123) and the table-fetch (reads `columns`); they read disjoint
    // keys, so the last recorded request is the appId table-fetch.
    s.setResponse(200, "{\"items\":[{\"id\":\"app_123\",\"slug\":\"crm\"}],"
        + "\"tableName\":\"orders\",\"columns\":["
        + "{\"name\":\"id\",\"type\":\"uuid\"},"
        + "{\"name\":\"total\",\"type\":\"numeric\"},"
        + "{\"name\":\"__proto__\",\"type\":\"text\"},"
        + "{\"name\":\"ok name\",\"type\":\"text\"}]}");
    DataTableClient tc = factory(s).discover("orders");
    require("/api/v1/apps/app_123/tables/orders".equals(s.path), "discover should hit appId path first, saw " + s.path);
    requireEq(Map.of("id", "uuid", "total", "number"), tc.schema().columns());
  }

  static void testDiscoverCachesAcrossChains(MockServer s) {
    s.setResponse(200, "{\"items\":[{\"id\":\"app_123\",\"slug\":\"crm\"}],"
        + "\"tableName\":\"orders\",\"columns\":[{\"name\":\"id\",\"type\":\"uuid\"}]}");
    s.reset();
    s.client().tenant("acme").app("crm").data().discover("orders");
    String first = s.path;
    s.reset();
    s.client().tenant("acme").app("crm").data().discover("orders");
    require("/api/v1/apps/app_123/tables/orders".equals(first), "first discover path drift " + first);
    require(s.path == null, "second discover should be served from cache, but server saw " + s.path);
  }

  static void testDiscover404BecomesTableNotFound(MockServer s) {
    s.setResponse(404, "{\"error\":{\"code\":\"not_found\",\"category\":\"not_found\"}}");
    expect(DataErrors.TableNotFoundError.class, () -> factory(s).discover("ghosts"));
  }

  // ============================ harness ====================================

  private static DataTableClient table(MockServer s) {
    return factory(s).table("orders");
  }

  private static AppDataFactory factory(MockServer s) {
    return s.client().tenant("acme").app("crm").data();
  }

  @FunctionalInterface interface Case { void run() throws Exception; }
  @FunctionalInterface interface ServerCase { void run(MockServer s) throws Exception; }

  private static void test(String name, Case c) {
    try {
      c.run();
      PASSED.incrementAndGet();
    } catch (Throwable t) {
      FAILURES.add(name + " -> " + t);
    }
  }

  private static void testServer(String name, ServerCase c) {
    MockServer s = null;
    try {
      s = new MockServer();
      c.run(s);
      PASSED.incrementAndGet();
    } catch (Throwable t) {
      FAILURES.add(name + " -> " + t);
    } finally {
      if (s != null) s.close();
    }
  }

  private static void require(boolean ok, String message) {
    if (!ok) throw new AssertionError(message);
  }

  private static void requireEq(Object expected, Object actual) {
    if (!java.util.Objects.equals(expected, actual)) {
      throw new AssertionError("expected " + expected + " but got " + actual);
    }
  }

  @SuppressWarnings("unchecked")
  private static <T extends Throwable> T expect(Class<T> type, Runnable r) {
    try {
      r.run();
    } catch (Throwable t) {
      if (type.isInstance(t)) return (T) t;
      throw new AssertionError("expected " + type.getSimpleName() + " but got " + t);
    }
    throw new AssertionError("expected " + type.getSimpleName() + " but nothing was thrown");
  }

  /** Single-threaded mock HTTP server that records the last request. */
  static final class MockServer implements AutoCloseable {
    private final HttpServer server;
    private final AxHubClient client;
    volatile String method;
    volatile String path;
    volatile String rawQuery;
    volatile String body;
    final Map<String, String> headers = new LinkedHashMap<>();
    private volatile int status = 200;
    private volatile String responseBody = "{}";

    MockServer() throws Exception {
      server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
      server.createContext("/", exchange -> {
        method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        path = uri.getPath();
        rawQuery = uri.getRawQuery();
        headers.clear();
        exchange.getRequestHeaders().forEach((k, v) -> {
          if (!v.isEmpty()) headers.put(k.toLowerCase(java.util.Locale.ROOT), v.get(0));
        });
        byte[] reqBody = exchange.getRequestBody().readAllBytes();
        body = reqBody.length == 0 ? null : new String(reqBody, StandardCharsets.UTF_8);
        byte[] out = responseBody.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(status, out.length);
        try (OutputStream os = exchange.getResponseBody()) { os.write(out); }
      });
      server.start();
      client = AxHubClient.builder()
          .baseUrl("http://127.0.0.1:" + server.getAddress().getPort())
          .token("pat_x")
          .tokenType(TokenType.PAT)
          .build();
    }

    AxHubClient client() { return client; }

    void setResponse(int status, String body) {
      this.status = status;
      this.responseBody = body;
    }

    void reset() {
      method = null;
      path = null;
      rawQuery = null;
      body = null;
      headers.clear();
    }

    Map<String, String> query() {
      Map<String, String> out = new LinkedHashMap<>();
      if (rawQuery == null || rawQuery.isEmpty()) return out;
      for (String pair : rawQuery.split("&")) {
        int eq = pair.indexOf('=');
        String key = eq < 0 ? pair : pair.substring(0, eq);
        String value = eq < 0 ? "" : pair.substring(eq + 1);
        out.put(decode(key), decode(value));
      }
      return out;
    }

    private static String decode(String s) {
      return java.net.URLDecoder.decode(s, StandardCharsets.UTF_8);
    }

    @Override
    public void close() {
      server.stop(0);
    }
  }
}
