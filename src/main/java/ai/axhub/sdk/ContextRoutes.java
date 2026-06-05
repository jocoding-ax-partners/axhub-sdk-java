package ai.axhub.sdk;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ContextRoutes {
  private ContextRoutes() {}
  public static final List<String> NAMES = List.of("apps", "identity", "tenants", "authz", "audit", "gateway", "data", "deployments");
  public static final Map<String, List<Route>> ALL = NAMES.stream().collect(Collectors.toUnmodifiableMap(name -> name, name -> Routes.ALL.stream().filter(route -> contextName(route).equals(name)).toList()));

  public static String contextName(Route route) {
    return switch (route.tag()) {
      case "Apps" -> "apps";
      case "Auth", "identity" -> "identity";
      case "Tenants" -> "tenants";
      case "Authorization" -> "authz";
      case "Audit" -> "audit";
      case "Gateway", "Config" -> "gateway";
      case "Schema" -> "data";
      case "Deploy", "deploy" -> "deployments";
      default -> "gateway";
    };
  }
}
