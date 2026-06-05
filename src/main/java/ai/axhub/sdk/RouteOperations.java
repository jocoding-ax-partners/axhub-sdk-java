package ai.axhub.sdk;

import java.util.Map;

final class RouteOperations {
  private RouteOperations() {}
  static Map<String, String> map(Map<String, String> value) { return value == null ? Map.of() : value; }
}
