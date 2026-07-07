package ai.axhub.sdk;

/**
 * Optional pagination controls for {@link RawDbClient#tableRows}. Non-positive values are omitted,
 * so a zero-valued options object (or {@code null}) uses the backend default page size.
 */
public record RawDbTableRowsOptions(int perPage, int page) {}
