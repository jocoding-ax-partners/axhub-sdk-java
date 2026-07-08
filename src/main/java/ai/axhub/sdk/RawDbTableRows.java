package ai.axhub.sdk;

import java.util.List;
import java.util.Map;

/**
 * One page of rows read from a raw DB table. {@code hasMore} is a per_page+1 probe — there is no
 * exact total.
 */
public record RawDbTableRows(List<Map<String, Object>> rows, int page, int perPage, boolean hasMore) {}
