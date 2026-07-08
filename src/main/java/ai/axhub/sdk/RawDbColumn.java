package ai.axhub.sdk;

/** One column of a raw (physical Postgres) DB table. */
public record RawDbColumn(String name, String dataType, boolean nullable) {}
