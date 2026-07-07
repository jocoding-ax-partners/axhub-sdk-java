package ai.axhub.sdk;

import java.util.List;

/** A physical table exposed by an app's raw DB (opt-in Postgres), with typed column metadata. */
public record RawDbTable(String name, boolean managed, List<RawDbColumn> columns) {}
