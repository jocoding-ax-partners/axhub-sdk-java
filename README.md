# AX Hub Java SDK

AX Hub Java SDK for `https://api.axhub.ai`. It exposes generated route metadata, typed error metadata, synchronous and async operation facades, regression/conformance tests, and a live-testable app/data workflow.

## Install

Gradle:

```groovy
implementation 'ai.axhub:axhub-sdk-java:0.4.0'
```

Maven:

```xml
<dependency>
  <groupId>ai.axhub</groupId>
  <artifactId>axhub-sdk-java</artifactId>
  <version>0.4.0</version>
</dependency>
```

Requires Java 21.

## Required environment for agent work

```bash
export AXHUB_TOKEN="<short-lived PAT>"
export AXHUB_TENANT_ID="cc1e58f1-8e46-4ac7-96c1-190c4cdd5b70"   # test tenant
export AXHUB_TENANT_SLUG="test"
```

PAT mode is explicit: `TokenType.PAT` sends `X-Api-Key`. JWT mode is `TokenType.JWT` and sends `Authorization: Bearer`.

## Agent quickstart: create a disposable app and enable its database

```java
import ai.axhub.sdk.AxHubClient;
import ai.axhub.sdk.TokenType;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    String tenantId = System.getenv("AXHUB_TENANT_ID");
    String tenantSlug = System.getenv("AXHUB_TENANT_SLUG");
    AxHubClient client = AxHubClient.builder()
        .baseUrl("https://api.axhub.ai")
        .token(System.getenv("AXHUB_TOKEN"))
        .tokenType(TokenType.PAT)
        .defaultTenantId(tenantId)
        .build();

    Map<String, Object> me = client.request("authGetApiV1Me", Map.of(), Map.of(), null);
    String userId = (String) me.get("userId");
    if (userId == null && me.get("user") instanceof Map<?, ?> user) userId = (String) user.get("id");
    if (userId == null) throw new IllegalStateException("authGetApiV1Me did not return a user id");

    String suffix = Long.toString(System.currentTimeMillis());
    String slug = "agent-java-" + suffix.substring(suffix.length() - 8);

    Map<String, Object> app = client.apps().create(Map.of(
        "slug", slug,
        "name", "Agent Java README QA",
        "visibility", "private",
        "auth_mode", "anonymous",
        "resource_preset", "S",
        "deploy_method", "docker",
        "subdomain", slug
    ));
    String appId = (String) app.get("id");

    // Enable raw DB mode: a dedicated Postgres role is issued and DATABASE_URL is
    // injected into the app on its next deploy. The app then does row CRUD over
    // direct SQL with its own pg driver.
    client.request("appsPostApiV1AppsByAppIDRawDb", Map.of("appID", appId), Map.of(), Map.of());

    // Admin introspection/browse of the physical DB.
    Map<String, Object> tables = client.request(
        "schemaGetApiV1AppsByAppIDDbTables", Map.of("appID", appId), Map.of(), null);

    System.out.println("created " + appId + " " + tables);
  }
}
```

## How to call the full API surface

- High-level app create: `client.apps().create(body)` uses `defaultTenantId`.
- Any route by operation id: `client.request(operationId, pathParams, query, body)`.
- Generated facade: `client.data().schemaGetApiV1AppsByAppIDDbTables(pathParams, query, body)`.
- Async facade: every generated method has an `Async` sibling returning `CompletableFuture<Map<String,Object>>`.
- Route inventory: `Routes.ALL`, `ContextRoutes.ALL`, and `ErrorCodes.ALL`.
- Errors: catch `AxHubException` and branch on `code()`, `category()`, `status()`, and `retryable()`.

## Dynamic app, schema, and data operations

Use the high-level `apps.create` helper for the first app, then use generated operation IDs for every backend route. Request bodies use backend wire keys, usually `snake_case`. Responses are normalized to camelCase in this SDK family, so read `tableName`, `requestId`, `revokedAt`, and similar keys from responses.

| Task | Operation ID | Required path params | Success assertion |
|------|--------------|----------------------|-------------------|
| Create env var | `appsPostApiV1AppsByAppIDEnvVars` | `appID` | `env.list` includes `key` |
| Delete env var | `appsDeleteApiV1AppsByAppIDEnvVarsByKey` | `appID`, `key` | `env.list` no longer includes `key` |
| Enable raw DB | `appsPostApiV1AppsByAppIDRawDb` | `appID` | dedicated Postgres role issued; `DATABASE_URL` injected on next deploy |
| Disable raw DB | `appsDeleteApiV1AppsByAppIDRawDb` | `appID` | raw DB mode turned off (data preserved) |
| List DB tables | `schemaGetApiV1AppsByAppIDDbTables` | `appID` | response lists physical `information_schema` tables |
| Browse DB rows | `schemaGetApiV1AppsByAppIDDbTablesByTableRows` | `appID`, `table` | response has `rows` array |
| Delete app | `appsDeleteApiV1AppsByAppID`, then `appsDeleteApiV1AppsByAppIDPermanent` | `appID` | app is soft-deleted, then permanently deleted |

Important semantics from live QA:

- App database access is raw: `appsPostApiV1AppsByAppIDRawDb` issues a dedicated Postgres role and injects `DATABASE_URL` on the next deploy (the connection string is never returned). The app does its own row CRUD via direct SQL; the SDK exposes admin introspection/browse only (`schemaGetApiV1AppsByAppIDDbTables` / `...DbTablesByTableRows`).
- Deployment creation without a connected git/bootstrap source can return a precondition-style 4xx. That verifies SDK error handling, not a deploy bug.


## Live QA evidence agents can trust

The SDK behavior documented here reflects live production QA against the AX Hub `test` tenant on 2026-06-08.

- Tenant used for destructive QA: slug `test`, id `cc1e58f1-8e46-4ac7-96c1-190c4cdd5b70`.
- Go, Java, Kotlin, Python, and Ruby each ran the generated all-operation sweep against 189 backend routes: SDK exceptions `0`, backend 5xx `0`.
- Go, Java, Kotlin, Python, and Ruby each passed strict destructive DB QA: the flow exercised the raw-DB enable/reset lifecycle (instead of the removed dynamic-table flow), then deleted the app and re-read to prove deletion semantics.
- Node ran the full production mutation suite and a real app bootstrap/deploy wait. Deployment id `d3a48ce3-0f9c-4bab-aa07-863c31c44460` finished `succeeded`, then the app was deleted permanently.

Do not print tokens. Use short-lived PATs for agent QA and revoke them after the run.


## Verification commands

Use local tests for every docs/code change. Run live tests only when you intentionally want destructive QA against `test`.


```bash
./gradlew check --no-daemon --console=plain

# Destructive live all-operation sweep, only with a disposable PAT.
AXHUB_LIVE_ALL_METHODS=1 \
AXHUB_TOKEN="$AXHUB_TOKEN" \
AXHUB_LIVE_TENANT_ID="$AXHUB_TENANT_ID" \
AXHUB_LIVE_TENANT_SLUG="$AXHUB_TENANT_SLUG" \
./gradlew regressionTest --no-daemon --console=plain
```

## Troubleshooting for agents

- `tenant_id_required`: pass `defaultTenantId` / `AXHUB_TENANT_ID` before calling `apps.create`.
- `tokenType must be explicit`: set PAT mode when using a PAT. PATs are sent as `X-Api-Key`; JWTs are sent as `Authorization: Bearer`.
- `slug_taken` or `schema_name_taken`: append a timestamp suffix and retry. Never reuse fixture names in live destructive QA.
- `permission_denied` / `not_admin`: the SDK is working. The token lacks the role for that route.
- `precondition_failed` on deploy: connect git or use the app bootstrap flow first.
- 4xx responses are expected for negative assertions. SDK bugs are unexpected exceptions, response decode failures, or backend 5xx during a valid call.


## Release

See `RELEASE.md` for tag order, environment approvals, registry prerequisites, and smoke-test handling.

## License

Apache-2.0.
