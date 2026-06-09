package ai.axhub.sdk.data;

import ai.axhub.sdk.data.Schema.DataColumn;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Predicate DSL: {@code where(col).eq(v)}, {@code and(...)}, {@code or}/{@code
 * not}/{@code raw} plus LIKE escaping and ReDoS guards (mirrors node dsl/ops.ts
 * and the Python port's dsl/ops.py).
 *
 * <p>Query expressions are plain maps:
 * <pre>
 *   {op: eq|ne|gt|gte|lt|lte|like, column: str, value: Any}
 *   {op: in, column: str, values: [...]}
 *   {op: and|or, clauses: [...]}
 *   {op: not, clause: expr}
 *   {op: raw, sql: str, params?: [...]}
 * </pre>
 * Only {@code and(eq/ne/gt/gte/lt/lte/in/like)} and bare atoms are pushable to
 * the live backend; or/not/raw raise in {@link WhereSerializer} (mirrors node).
 */
public final class Ops {
  private Ops() {}

  public static final int MAX_LIKE_PATTERN_LENGTH = 1024;
  public static final int MAX_CONSECUTIVE_WILDCARDS = 4;
  public static final int MAX_LIKE_ALTERNATION_SEGMENTS = 6;

  public static String escapeLike(String value) {
    if (value.isEmpty()) return value;
    StringBuilder out = new StringBuilder(value.length());
    for (int i = 0; i < value.length(); i++) {
      char ch = value.charAt(i);
      if (ch == '\\' || ch == '%' || ch == '_') out.append('\\');
      out.append(ch);
    }
    return out.toString();
  }

  /**
   * Reject LIKE patterns that translate to catastrophic-backtracking regex
   * shapes (mirrors node assertSafeLikePattern).
   */
  public static void assertSafeLikePattern(String pattern) {
    if (pattern.length() > MAX_LIKE_PATTERN_LENGTH) {
      throw new DataErrors.ValidationError(
          "LIKE pattern exceeds " + MAX_LIKE_PATTERN_LENGTH + " chars; refuse to compile",
          "like_pattern_too_long");
    }
    int runOfWildcards = 0;
    int segments = 0;
    int i = 0;
    int n = pattern.length();
    while (i < n) {
      char ch = pattern.charAt(i);
      if (ch == '\\') {
        i += 2;
        runOfWildcards = 0;
        continue;
      }
      if (ch == '%') {
        runOfWildcards += 1;
        if (runOfWildcards >= MAX_CONSECUTIVE_WILDCARDS) {
          throw new DataErrors.ValidationError(
              "LIKE pattern has " + runOfWildcards + " consecutive '%'; refuse to compile (ReDoS guard)",
              "like_pattern_redos");
        }
      } else {
        if (runOfWildcards == 1) segments += 1;
        runOfWildcards = 0;
      }
      i += 1;
    }
    if (segments > MAX_LIKE_ALTERNATION_SEGMENTS) {
      throw new DataErrors.ValidationError(
          "LIKE pattern has " + segments + " '%X%' alternation segments; refuse to compile (ReDoS guard)",
          "like_pattern_redos");
    }
  }

  public static Map<String, Object> raw(String sql, List<Object> params) {
    Map<String, Object> out = new LinkedHashMap<>();
    out.put("op", "raw");
    out.put("sql", sql);
    if (params != null) out.put("params", params);
    return out;
  }

  public static Map<String, Object> raw(String sql) {
    return raw(sql, null);
  }

  @SafeVarargs
  public static Map<String, Object> and(Map<String, Object>... clauses) {
    return combine("and", clauses);
  }

  @SafeVarargs
  public static Map<String, Object> or(Map<String, Object>... clauses) {
    return combine("or", clauses);
  }

  public static Map<String, Object> not(Map<String, Object> clause) {
    Map<String, Object> out = new LinkedHashMap<>();
    out.put("op", "not");
    out.put("clause", clause);
    return out;
  }

  @SafeVarargs
  private static Map<String, Object> combine(String op, Map<String, Object>... clauses) {
    Map<String, Object> out = new LinkedHashMap<>();
    out.put("op", op);
    out.put("clauses", List.of(clauses));
    return out;
  }

  public static WhereBuilder where(String column) {
    return new WhereBuilder(column);
  }

  public static WhereBuilder where(DataColumn column) {
    return new WhereBuilder(column.name());
  }

  /** Fluent builder for a single column's pushable comparison atoms. */
  public static final class WhereBuilder {
    private final String name;
    public final LikeBuilder like;

    WhereBuilder(String name) {
      this.name = name;
      this.like = new LikeBuilder(name);
    }

    private Map<String, Object> binary(String op, Object value) {
      Map<String, Object> out = new LinkedHashMap<>();
      out.put("op", op);
      out.put("column", name);
      out.put("value", value);
      return out;
    }

    public Map<String, Object> eq(Object value) { return binary("eq", value); }
    public Map<String, Object> ne(Object value) { return binary("ne", value); }
    public Map<String, Object> gt(Object value) { return binary("gt", value); }
    public Map<String, Object> gte(Object value) { return binary("gte", value); }
    public Map<String, Object> lt(Object value) { return binary("lt", value); }
    public Map<String, Object> lte(Object value) { return binary("lte", value); }

    public Map<String, Object> in(List<?> values) {
      Map<String, Object> out = new LinkedHashMap<>();
      out.put("op", "in");
      out.put("column", name);
      out.put("values", List.copyOf(values));
      return out;
    }
  }

  /** LIKE sub-builder: contains/startsWith/endsWith escape input; raw is the trusted escape hatch. */
  public static final class LikeBuilder {
    private final String name;
    LikeBuilder(String name) { this.name = name; }

    private Map<String, Object> like(String value) {
      Map<String, Object> out = new LinkedHashMap<>();
      out.put("op", "like");
      out.put("column", name);
      out.put("value", value);
      return out;
    }

    public Map<String, Object> contains(String value) { return like("%" + escapeLike(value) + "%"); }
    public Map<String, Object> startsWith(String value) { return like(escapeLike(value) + "%"); }
    public Map<String, Object> endsWith(String value) { return like("%" + escapeLike(value)); }
    public Map<String, Object> raw(String value) {
      assertSafeLikePattern(value);
      return like(value);
    }
  }
}
