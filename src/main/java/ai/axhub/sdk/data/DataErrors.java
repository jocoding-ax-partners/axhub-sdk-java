package ai.axhub.sdk.data;

import ai.axhub.sdk.AxHubException;

/**
 * Typed data-layer errors.
 *
 * <p>These subclass the existing {@link AxHubException} so the {@code (category,
 * code)} contract that the conformance vectors and error tests match on keeps
 * working, while callers can still {@code instanceof}-narrow on the specific
 * failure (mirrors node's {@code LegacyCursorError} / {@code InvalidCursorError}
 * / {@code ValidationError} / {@code TableNotFoundError} /
 * {@code IntrospectFailedError} / {@code ScanLimitExceededError} hierarchy and
 * the Python port's {@code errors.py}).
 *
 * <p>These are plain exception classes, NOT {@code ErrorCodes.ALL} registry
 * entries, so the route/error-count gates in {@code RegressionTest} are
 * unaffected.
 */
public final class DataErrors {
  private DataErrors() {}

  /** Generic client-side validation failure (select, filters, schema validation). */
  public static final class ValidationError extends AxHubException {
    public ValidationError(String message, String code) {
      super("validation", code, message, 0, false);
    }
    public ValidationError(String message) {
      this(message, "validation");
    }
  }

  /**
   * Raised when an after/before keyset or v1:/v2: cursor token is supplied; the
   * live AX Hub data API is offset-only (mirrors node LegacyCursorError).
   */
  public static final class LegacyCursorError extends AxHubException {
    public LegacyCursorError(String message) {
      super("validation", "legacy_cursor", message, 0, false);
    }
  }

  public static final class InvalidCursorError extends AxHubException {
    public InvalidCursorError(String message) {
      super("validation", "invalid_cursor", message, 0, false);
    }
  }

  public static final class TableNotFoundError extends AxHubException {
    public TableNotFoundError(String message) {
      this(message, null);
    }
    public TableNotFoundError(String message, String requestId) {
      super("not_found", "table_not_found", message, 404, false, requestId);
    }
  }

  public static final class IntrospectFailedError extends AxHubException {
    public IntrospectFailedError(String message) {
      this(message, 0, false, null);
    }
    public IntrospectFailedError(String message, int status, boolean retryable, String requestId) {
      super("internal", "introspect_failed", message, status, retryable, requestId);
    }
  }

  public static final class ScanLimitExceededError extends AxHubException {
    public ScanLimitExceededError(String message) {
      super("internal", "scan_limit_exceeded", message, 0, false);
    }
  }

  /** Misconfigured validator on a schema (mirrors node ConfigurationError zod_missing). */
  public static final class ConfigurationError extends AxHubException {
    public ConfigurationError(String message, String code) {
      super("configuration", code, message, 0, false);
    }
  }
}
