package ai.axhub.sdk;

public record ErrorInfo(String category, int status, boolean retryable) {}
