package ai.axhub.sdk.data;

import ai.axhub.sdk.data.Schema.DataTableSchema;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Column projection: {@code select} serialization, validation, and client-side
 * row narrowing (mirrors node projection.ts and the Python port's
 * projection.py).
 *
 * <p>{@code serializeSelect} joins columns with commas into the {@code _select}
 * query param. {@code validateSelectColumns} rejects an empty select and, when a
 * schema is known, unknown columns. {@code projectRow}/{@code projectRows}
 * narrow returned rows to the selected keys client-side.
 */
public final class Projection {
  private Projection() {}

  public static String serializeSelect(List<String> select) {
    if (select == null) return null;
    return String.join(",", select);
  }

  public static void validateSelectColumns(DataTableSchema schema, List<String> select) {
    if (select == null) return;
    if (select.isEmpty()) {
      throw new DataErrors.ValidationError(
          "select must include at least one column; omit select to fetch full rows",
          "select_empty");
    }
    if (schema == null) return;
    var allowed = schema.columns().keySet();
    List<String> invalid = new ArrayList<>();
    for (String c : select) {
      if (!allowed.contains(c)) invalid.add(c);
    }
    if (invalid.isEmpty()) return;
    String plural = invalid.size() == 1 ? "" : "s";
    throw new DataErrors.ValidationError(
        "select contains unknown column" + plural + ": " + String.join(", ", invalid),
        "select_unknown_column");
  }

  public static Map<String, Object> projectRow(Map<String, Object> row, List<String> select) {
    if (select == null) return new LinkedHashMap<>(row);
    Map<String, Object> out = new LinkedHashMap<>();
    for (String k : select) {
      if (row.containsKey(k)) out.put(k, row.get(k));
    }
    return out;
  }

  @SuppressWarnings("unchecked")
  public static List<Map<String, Object>> projectRows(List<?> rows, List<String> select) {
    List<Map<String, Object>> out = new ArrayList<>(rows.size());
    for (Object r : rows) {
      Map<String, Object> row = (Map<String, Object>) r;
      out.add(projectRow(row, select));
    }
    return out;
  }
}
