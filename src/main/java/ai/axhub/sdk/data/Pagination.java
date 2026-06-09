package ai.axhub.sdk.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * Offset pagination helpers used by the data layer (subset of node core
 * pagination.ts that the data ergonomic layer depends on; mirrors the Python
 * port's pagination.py).
 *
 * <p>Ported: {@code serializeOrderBy} / {@code normalizeOrderBy},
 * {@code isV2Cursor}, {@code MAX_CURSOR_TOKEN_LENGTH}, {@code listAll}, and the
 * {@code PaginatedList} / {@code ListAllItem} result shapes. Keyset
 * encode/decode is intentionally NOT ported: the live AX Hub data API is
 * offset-only (see node, gap-matrix S7-S9).
 */
public final class Pagination {
  private Pagination() {}

  public static final int MAX_CURSOR_TOKEN_LENGTH = 4096;

  /** One offset page plus the cursor envelope (mirrors node PaginatedList). */
  public static final class PaginatedList {
    public final List<Map<String, Object>> items;
    public final String nextCursor;
    public final String firstCursor;
    public final Boolean hasNext;
    public final Boolean hasPrev;
    public final Integer total;
    public final Boolean totalIsExact;

    public PaginatedList(List<Map<String, Object>> items, String nextCursor, String firstCursor,
                         Boolean hasNext, Boolean hasPrev, Integer total, Boolean totalIsExact) {
      this.items = items;
      this.nextCursor = nextCursor;
      this.firstCursor = firstCursor;
      this.hasNext = hasNext;
      this.hasPrev = hasPrev;
      this.total = total;
      this.totalIsExact = totalIsExact;
    }
  }

  /**
   * Either an item ({@code type == "item"}) or a drift marker
   * ({@code type == "drift"}) when the backend total grows mid-scan.
   */
  public static final class ListAllItem {
    public final String type;
    public final Map<String, Object> value;
    public final int addedSince;

    private ListAllItem(String type, Map<String, Object> value, int addedSince) {
      this.type = type;
      this.value = value;
      this.addedSince = addedSince;
    }

    public static ListAllItem item(Map<String, Object> value) { return new ListAllItem("item", value, 0); }
    public static ListAllItem drift(int addedSince) { return new ListAllItem("drift", null, addedSince); }
  }

  /** A single order-by clause: field + direction ("asc"/"desc"). */
  public record OrderField(String field, String dir) {}

  /** {@code orderBy} may be a String ("-total,name") or a {@code List<OrderField>}. */
  public static List<OrderField> normalizeOrderBy(Object orderBy) {
    List<OrderField> fields = new ArrayList<>();
    if (orderBy instanceof String s) {
      for (String part : s.split(",")) {
        String trimmed = part.strip();
        if (trimmed.isEmpty()) continue;
        if (trimmed.startsWith("-")) fields.add(new OrderField(trimmed.substring(1), "desc"));
        else if (trimmed.startsWith("+")) fields.add(new OrderField(trimmed.substring(1), "asc"));
        else fields.add(new OrderField(trimmed, "asc"));
      }
    } else if (orderBy instanceof List<?> list) {
      for (Object o : list) {
        if (o instanceof OrderField f) {
          fields.add(new OrderField(f.field(), f.dir() == null ? "asc" : f.dir()));
        } else if (o instanceof Map<?, ?> m) {
          Object field = m.get("field");
          Object dir = m.get("dir");
          fields.add(new OrderField(String.valueOf(field), dir == null ? "asc" : String.valueOf(dir)));
        }
      }
    }
    boolean hasId = fields.stream().anyMatch(f -> "id".equals(f.field()));
    if (!fields.isEmpty() && !hasId) fields.add(new OrderField("id", "asc"));
    return fields;
  }

  public static String serializeOrderBy(Object orderBy) {
    List<OrderField> normalized = normalizeOrderBy(orderBy);
    if (normalized.isEmpty()) return orderBy instanceof String s ? s : null;
    StringBuilder out = new StringBuilder();
    for (OrderField f : normalized) {
      if (out.length() > 0) out.append(',');
      if ("desc".equals(f.dir())) out.append('-');
      out.append(f.field());
    }
    return out.toString();
  }

  public static boolean isV2Cursor(Object token) {
    return token instanceof String s && s.startsWith("v2:");
  }

  /** Per-page request seed for the {@code listAll} fetcher: cursor + page size. */
  public record PageRequest(String cursor, Integer pageSize) {}

  /**
   * Drive a paginated fetcher to exhaustion, yielding each item and a drift
   * marker when the backend total grows mid-iteration (mirrors node listAll).
   */
  public static Iterator<ListAllItem> listAll(Function<PageRequest, PaginatedList> fetcher, Integer pageSize) {
    return new Iterator<>() {
      private String cursor = null;
      private Integer initialTotal = null;
      private Integer lastTotal = null;
      private final List<ListAllItem> buffer = new ArrayList<>();
      private int bufferPos = 0;
      private boolean done = false;

      private void fill() {
        while (bufferPos >= buffer.size() && !done) {
          buffer.clear();
          bufferPos = 0;
          PaginatedList page = fetcher.apply(new PageRequest(cursor, pageSize));
          if (page.total != null) {
            if (initialTotal == null) {
              initialTotal = page.total;
              lastTotal = page.total;
            } else {
              int base = lastTotal != null ? lastTotal : initialTotal;
              if (page.total > base) {
                buffer.add(ListAllItem.drift(page.total - base));
                lastTotal = page.total;
              }
            }
          }
          for (Map<String, Object> item : page.items) buffer.add(ListAllItem.item(item));
          if (page.nextCursor == null) done = true;
          else cursor = page.nextCursor;
        }
      }

      @Override
      public boolean hasNext() {
        fill();
        return bufferPos < buffer.size();
      }

      @Override
      public ListAllItem next() {
        if (!hasNext()) throw new NoSuchElementException();
        return buffer.get(bufferPos++);
      }
    };
  }
}
