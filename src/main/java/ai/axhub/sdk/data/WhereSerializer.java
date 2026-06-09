package ai.axhub.sdk.data;

import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Serialize the predicate DSL into backend filter query params (mirrors node
 * where-serializer.ts and the Python port's where_serializer.py).
 *
 * <p>Each pushable atom becomes {@code column=<op>.<value>} (PostgREST-style).
 * Repeated columns collapse into a list so the transport emits repeated query
 * params. Only top-level {@code and(...)} of pushable atoms and bare atoms are
 * accepted; or/not/raw and nested and raise {@link DataErrors.ValidationError}
 * — this matches the live backend's filter grammar (see node, gap-matrix S7-S9).
 */
public final class WhereSerializer {
  private WhereSerializer() {}

  private static final Set<String> PUSHABLE_BINARY = Set.of("eq", "ne", "gt", "gte", "lt", "lte", "like");

  /** @return a query map whose values are {@code String} or {@code List<String>}. */
  public static Map<String, Object> serializeWhere(Map<String, Object> expr) {
    if (expr == null) return new LinkedHashMap<>();
    Map<String, Object> out = new LinkedHashMap<>();
    for (Filter f : collectPushableFilters(expr, true)) {
      appendQuery(out, f.column, f.value);
    }
    return out;
  }

  private record Filter(String column, String value) {}

  @SuppressWarnings("unchecked")
  private static void appendQuery(Map<String, Object> out, String key, String value) {
    Object existing = out.get(key);
    if (!out.containsKey(key)) {
      out.put(key, value);
    } else if (existing instanceof List) {
      ((List<String>) existing).add(value);
    } else {
      List<String> list = new ArrayList<>();
      list.add((String) existing);
      list.add(value);
      out.put(key, list);
    }
  }

  @SuppressWarnings("unchecked")
  private static List<Filter> collectPushableFilters(Map<String, Object> expr, boolean allowAnd) {
    Object op = expr.get("op");
    if (op instanceof String s && PUSHABLE_BINARY.contains(s)) {
      return List.of(new Filter((String) expr.get("column"), s + "." + stringify(expr.get("value"))));
    }
    if ("in".equals(op)) {
      List<Object> rawValues = (List<Object>) expr.get("values");
      List<String> values = new ArrayList<>();
      for (Object v : rawValues) values.add(stringify(v));
      String bad = values.stream().filter(v -> v.contains(",")).findFirst().orElse(null);
      if (bad != null) {
        throw new DataErrors.ValidationError(
            "IN filter values cannot contain commas because the live backend uses comma-separated IN lists (bad value: " + bad + ")",
            "filter_in_comma");
      }
      return List.of(new Filter((String) expr.get("column"), "in." + String.join(",", values)));
    }
    if ("and".equals(op) && allowAnd) {
      List<Filter> out = new ArrayList<>();
      for (Object clause : (List<Object>) expr.get("clauses")) {
        out.addAll(collectPushableFilters((Map<String, Object>) clause, false));
      }
      return out;
    }
    // or / not / raw / nested-and all fall through to the rejection below.
    throw new DataErrors.ValidationError(
        "Data where clause '" + op + "' cannot be pushed to the live backend; use top-level and(eq/ne/gt/gte/lt/lte/in/like) only",
        "unsupported_filter");
  }

  private static String stringify(Object value) {
    if (value == null) return "null";
    if (value instanceof Boolean b) return b ? "true" : "false";
    if (value instanceof TemporalAccessor t) return t.toString();
    if (value instanceof String || value instanceof Number) return String.valueOf(value);
    return String.valueOf(value);
  }
}
