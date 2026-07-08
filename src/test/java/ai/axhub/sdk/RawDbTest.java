package ai.axhub.sdk;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

final class RawDbTest {
  static void run() throws Exception {
    tablesParsesTypedColumns();
    tablesEmptyMeansGenuinelyEmpty();
    tableRowsParsesPageAndForwardsPerPage();
    inputsAreValidatedBeforeAnyRequest();
  }

  // snake_case wire shape; the transport camelCases keys before the facade parses them.
  static void tablesParsesTypedColumns() throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext("/", exchange -> {
      require("/api/v1/apps/app_x/db/tables".equals(exchange.getRequestURI().getPath()),
          "unexpected path " + exchange.getRequestURI().getPath());
      byte[] body = ("{\"tables\":[{\"name\":\"posts\",\"managed\":false,\"columns\":["
          + "{\"name\":\"id\",\"data_type\":\"uuid\",\"nullable\":false},"
          + "{\"name\":\"title\",\"data_type\":\"text\",\"nullable\":true}]}]}").getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "application/json");
      exchange.sendResponseHeaders(200, body.length);
      try (OutputStream os = exchange.getResponseBody()) { os.write(body); }
    });
    server.start();
    try {
      List<RawDbTable> tables = client(server).apps().rawDb().tables("app_x");
      require(tables.size() == 1 && "posts".equals(tables.get(0).name()) && tables.get(0).columns().size() == 2,
          "unexpected tables " + tables);
      require("uuid".equals(tables.get(0).columns().get(0).dataType()) && tables.get(0).columns().get(1).nullable(),
          "columns not parsed typed " + tables.get(0).columns());
    } finally { server.stop(0); }
  }

  // F-3: empty list + no exception = genuinely empty (raw DB not enabled or 0 tables), not auth failure.
  static void tablesEmptyMeansGenuinelyEmpty() throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext("/", exchange -> {
      byte[] body = "{\"tables\":[]}".getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "application/json");
      exchange.sendResponseHeaders(200, body.length);
      try (OutputStream os = exchange.getResponseBody()) { os.write(body); }
    });
    server.start();
    try {
      List<RawDbTable> tables = client(server).apps().rawDb().tables("app_x");
      require(tables.isEmpty(), "empty tables must not error and must be empty, got " + tables);
    } finally { server.stop(0); }
  }

  static void tableRowsParsesPageAndForwardsPerPage() throws Exception {
    final String[] seenQuery = new String[1];
    HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
    server.createContext("/", exchange -> {
      seenQuery[0] = exchange.getRequestURI().getQuery();
      byte[] body = "{\"rows\":[{\"id\":\"1\"},{\"id\":\"2\"}],\"page\":1,\"per_page\":100,\"has_more\":true}"
          .getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "application/json");
      exchange.sendResponseHeaders(200, body.length);
      try (OutputStream os = exchange.getResponseBody()) { os.write(body); }
    });
    server.start();
    try {
      RawDbTableRows page = client(server).apps().rawDb().tableRows("app_x", "posts", new RawDbTableRowsOptions(100, 0));
      require(seenQuery[0] != null && seenQuery[0].contains("per_page=100"), "per_page not forwarded: " + seenQuery[0]);
      require(page.rows().size() == 2 && page.perPage() == 100 && page.hasMore(), "page not parsed " + page);
    } finally { server.stop(0); }
  }

  static void inputsAreValidatedBeforeAnyRequest() {
    // Unreachable base URL: a validation guard must throw before any HTTP call is attempted.
    AxHubClient client = AxHubClient.builder().baseUrl("http://127.0.0.1:1").token("t").tokenType(TokenType.PAT).build();
    try {
      client.apps().rawDb().tableRows("app_x", "", null);
      throw new AssertionError("empty table should error before any request");
    } catch (AxHubException e) {
      require("validation".equals(e.category()) && "required".equals(e.code()), "wrong tableRows validation error " + e);
    }
    try {
      client.apps().rawDb().tables("");
      throw new AssertionError("empty appID should error before any request");
    } catch (AxHubException e) {
      require("validation".equals(e.category()) && "required".equals(e.code()), "wrong tables validation error " + e);
    }
  }

  private static AxHubClient client(HttpServer server) {
    return AxHubClient.builder()
        .baseUrl("http://127.0.0.1:" + server.getAddress().getPort())
        .token("t")
        .tokenType(TokenType.PAT)
        .build();
  }

  private static void require(boolean ok, String message) {
    if (!ok) throw new AssertionError(message);
  }
}
