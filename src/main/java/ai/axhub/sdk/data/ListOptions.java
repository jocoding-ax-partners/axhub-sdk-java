package ai.axhub.sdk.data;

import java.util.List;
import java.util.Map;

/**
 * Options for {@code list} / {@code listAll} (mirrors node DataListOptions).
 * Fluent builder so the common case stays terse:
 * <pre>
 *   table.list(ListOptions.create().where(eq).orderBy("-total").page(2).pageSize(10));
 * </pre>
 *
 * <p>{@code after} / {@code before} / {@code direction} exist only so the layer
 * can reject them: the live AX Hub data API is offset-only (see node,
 * gap-matrix S7-S9).
 */
public final class ListOptions {
  Map<String, Object> where;
  Object orderBy;
  List<String> select;
  Integer limit;
  Integer pageSize;
  Integer page;
  String cursor;
  Object after;
  Object before;
  Object direction;

  private ListOptions() {}

  public static ListOptions create() {
    return new ListOptions();
  }

  public ListOptions where(Map<String, Object> where) { this.where = where; return this; }
  public ListOptions orderBy(Object orderBy) { this.orderBy = orderBy; return this; }
  public ListOptions select(List<String> select) { this.select = select; return this; }
  public ListOptions select(String... select) { this.select = List.of(select); return this; }
  public ListOptions limit(Integer limit) { this.limit = limit; return this; }
  public ListOptions pageSize(Integer pageSize) { this.pageSize = pageSize; return this; }
  public ListOptions page(Integer page) { this.page = page; return this; }
  public ListOptions cursor(String cursor) { this.cursor = cursor; return this; }

  /** @deprecated AX Hub data API is offset-only; supplying this raises LegacyCursorError. */
  @Deprecated public ListOptions after(Object after) { this.after = after; return this; }
  /** @deprecated AX Hub data API is offset-only; supplying this raises LegacyCursorError. */
  @Deprecated public ListOptions before(Object before) { this.before = before; return this; }
  /** @deprecated AX Hub data API is offset-only; supplying this raises LegacyCursorError. */
  @Deprecated public ListOptions direction(Object direction) { this.direction = direction; return this; }

  ListOptions copy() {
    ListOptions c = new ListOptions();
    c.where = where;
    c.orderBy = orderBy;
    c.select = select;
    c.limit = limit;
    c.pageSize = pageSize;
    c.page = page;
    c.cursor = cursor;
    c.after = after;
    c.before = before;
    c.direction = direction;
    return c;
  }
}
