package ai.axhub.sdk.example;

import ai.axhub.sdk.AxHubClient;
import ai.axhub.sdk.TokenType;
import ai.axhub.sdk.data.DataTableClient;
import ai.axhub.sdk.data.ListOptions;
import ai.axhub.sdk.data.Ops;
import ai.axhub.sdk.data.Pagination.PaginatedList;
import ai.axhub.sdk.data.Schema;
import ai.axhub.sdk.data.Schema.DataTableSchema;
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

/**
 * Ergonomic data-layer CRUD demo (mirrors node examples/data-crud-demo.ts).
 *
 * <p>Node:
 * <pre>
 *   const Orders = defineSchema({ table: 'orders', columns: { id: 'uuid', total: 'number' } })
 *   const table = sdk.tenant('acme').app('crm').data.table(Orders)
 *   console.log(await table.count())
 * </pre>
 *
 * <p>Like {@code App}, this env-gates the live path ({@code AXHUB_TOKEN}) and
 * otherwise runs against a local mock server so it stays network-free in
 * {@code check}.
 */
public final class DataCrudDemo {
  public static void main(String[] args) throws Exception {
    String token = System.getenv("AXHUB_TOKEN");
    if (token != null && !token.isBlank()) {
      runProd(token);
      return;
    }
    runLocal();
  }

  private static final DataTableSchema ORDERS =
      Schema.defineSchema("orders", Map.of("id", "uuid", "total", "number"));

  private static void runProd(String token) {
    String baseUrl = envOr("AXHUB_BASE_URL", "https://api.axhub.ai");
    AxHubClient sdk = AxHubClient.builder()
        .baseUrl(baseUrl)
        .token(token)
        .tokenType(TokenType.valueOf(envOr("AXHUB_TOKEN_TYPE", "pat").toUpperCase()))
        .build();
    String tenant = envOr("AXHUB_TENANT_SLUG", "acme");
    String app = envOr("AXHUB_APP_SLUG", "crm");
    DataTableClient table = sdk.tenant(tenant).app(app).data().table(ORDERS);
    // The live data ring rejects an unfiltered count (mass-scan guard), so pass a
    // pushable predicate (mirrors the python port's data_crud_demo).
    System.out.println("java data crud demo count=" + table.count(Ops.where("total").gte(10)));
  }

  private static void runLocal() throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    server.createContext("/", ex -> {
      String path = ex.getRequestURI().getPath();
      byte[] body;
      if (path.endsWith("/_count")) {
        body = "{\"count\":2}".getBytes();
      } else if ("POST".equals(ex.getRequestMethod())) {
        body = "{\"id\":\"ord_1\",\"total\":42}".getBytes();
      } else {
        body = "{\"items\":[{\"id\":\"ord_1\",\"total\":42}],\"page\":1,\"has_more\":false}".getBytes();
      }
      ex.sendResponseHeaders(200, body.length);
      try (OutputStream os = ex.getResponseBody()) { os.write(body); }
    });
    server.start();
    try {
      AxHubClient sdk = AxHubClient.builder()
          .baseUrl("http://127.0.0.1:" + server.getAddress().getPort())
          .token("pat_demo")
          .tokenType(TokenType.PAT)
          .build();
      DataTableClient table = sdk.tenant("acme").app("crm").data().table(ORDERS);

      int count = table.count(Ops.where("total").gte(10));
      Map<String, Object> inserted = table.insert(Map.of("total", 42));
      PaginatedList page = table.list(ListOptions.create()
          .where(Ops.where("total").gte(10))
          .orderBy("-total")
          .select(List.of("id", "total"))
          .pageSize(50));

      System.out.println("java data crud demo ok count=" + count
          + " inserted=" + inserted.get("id")
          + " listed=" + page.items.size());
    } finally {
      server.stop(0);
    }
  }

  private static String envOr(String key, String fallback) {
    String value = System.getenv(key);
    return value == null || value.isBlank() ? fallback : value;
  }
}
