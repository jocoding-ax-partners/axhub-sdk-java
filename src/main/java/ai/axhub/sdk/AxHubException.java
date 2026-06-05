package ai.axhub.sdk;

public class AxHubException extends RuntimeException {
  private final String category;
  private final String code;
  private final int status;
  private final boolean retryable;
  private final String requestId;

  public AxHubException(String category, String code, String message, int status, boolean retryable) {
    this(category, code, message, status, retryable, null);
  }

  public AxHubException(String category, String code, String message, int status, boolean retryable, String requestId) {
    super(message == null || message.isBlank() ? code : message);
    this.category = category;
    this.code = code;
    this.status = status;
    this.retryable = retryable;
    this.requestId = requestId;
  }

  public String category() { return category; }
  public String code() { return code; }
  public int status() { return status; }
  public boolean retryable() { return retryable; }
  public String requestId() { return requestId; }
}
