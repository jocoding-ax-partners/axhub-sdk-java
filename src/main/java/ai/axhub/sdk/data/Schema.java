package ai.axhub.sdk.data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Schema definitions and {@code defineSchema} (mirrors node dsl/schema.ts and
 * the Python port's dsl/schema.py).
 *
 * <p>Column defs are either a primitive type string ({@code uuid | string |
 * number | integer | boolean | timestamp | json}) or an enum descriptor
 * (a {@code Map} with {@code type=enum} and {@code values=[...]}). {@code cols}
 * holds the accessor map used by the typed {@code where(schema.cols().get("x"))}
 * DSL path.
 */
public final class Schema {
  private Schema() {}

  /** A single column descriptor: its owning table, name, and type def. */
  public record DataColumn(String table, String name, Object definition) {}

  /** Immutable table schema: name, columns shape, accessor map, optional validator. */
  public static final class DataTableSchema {
    private final String table;
    private final Map<String, Object> columns;
    private final Map<String, DataColumn> cols;
    private final Object validate; // duck-typed validator (safeParse / safe_parse), or null

    public DataTableSchema(String table, Map<String, Object> columns, Map<String, DataColumn> cols, Object validate) {
      this.table = table;
      this.columns = Map.copyOf(columns);
      this.cols = Map.copyOf(cols);
      this.validate = validate;
    }

    public String table() { return table; }
    public Map<String, Object> columns() { return columns; }
    public Map<String, DataColumn> cols() { return cols; }
    public Object validate() { return validate; }
  }

  /**
   * Define a data table schema.
   *
   * <pre>
   *   defineSchema("orders", Map.of("id", "uuid", "total", "number"))
   * </pre>
   */
  public static DataTableSchema defineSchema(String table, Map<String, ?> columns) {
    return defineSchema(table, columns, null);
  }

  /** Define a schema with an optional duck-typed validator (mirrors node validate option). */
  public static DataTableSchema defineSchema(String table, Map<String, ?> columns, Object validate) {
    if (columns == null) {
      throw new IllegalArgumentException("defineSchema requires columns");
    }
    Map<String, Object> shape = new LinkedHashMap<>(columns);
    Map<String, DataColumn> cols = new LinkedHashMap<>();
    for (var e : shape.entrySet()) {
      cols.put(e.getKey(), new DataColumn(table, e.getKey(), e.getValue()));
    }
    return new DataTableSchema(table, shape, cols, validate);
  }

  /** Re-wrap an existing schema, optionally attaching/replacing a validator. */
  public static DataTableSchema defineSchema(DataTableSchema input, Object validate) {
    return new DataTableSchema(input.table(), input.columns(), input.cols(),
        validate != null ? validate : input.validate());
  }
}
