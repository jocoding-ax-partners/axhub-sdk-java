package ai.axhub.sdk;

import java.lang.reflect.Method;
import java.util.Map;

final class OperationsCoverageTest {
  static void run() throws Exception {
    AxHubClient c = AxHubClient.builder().baseUrl("http://127.0.0.1:1").build();
    Map<String, Object> contexts = Map.of(
      "apps", c.appsRoutes(), "identity", c.identity(), "tenants", c.tenants(), "authz", c.authz(),
      "audit", c.audit(), "gateway", c.gateway(), "cost", c.cost(), "data", c.data(), "deployments", c.deployments()
    );
    if (Routes.ALL.size() != 185) throw new AssertionError("route metadata drift " + Routes.ALL.size());
    for (Route route : Routes.ALL) {
      Object context = contexts.get(ContextRoutes.contextName(route));
      Method m = context.getClass().getMethod(route.operationId(), Map.class, Map.class, Object.class);
      if (m == null) throw new AssertionError("missing method " + route.operationId());
    }
  }
}
