package ai.axhub.sdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Full member-surface DESTRUCTIVE lifecycle against live prod (create/update/delete real
 * resources). 1:1 translation of go live_destructive_lifecycle_test.go — the snake_case wire
 * bodies, operationIds, and path-param keys are the BACKEND CONTRACT (proven against live prod).
 *
 * Opt-in only: main() runs nothing unless AXHUB_LIVE_DESTRUCTIVE=1. Fixtures are disposable with
 * prefix "sdke2e-java-" and LIFO best-effort cleanup that runs even when the lifecycle throws, so
 * the orchestrator can orphan-sweep. Admin-sdk-scoped ops are out of scope (ADR-0043).
 */
public final class LiveDestructiveLifecycleTest {
  public static void main(String[] args) {
    if (!"1".equals(System.getenv("AXHUB_LIVE_DESTRUCTIVE"))) {
      System.out.println("skipped (opt-in)");
      return;
    }
    run();
  }

  static void run() {
    String base = getenv("AXHUB_LIVE_BASE_URL", "https://api.axhub.ai");
    String tenantId = getenv("AXHUB_LIVE_TENANT_ID", "cc1e58f1-8e46-4ac7-96c1-190c4cdd5b70");
    String token = requireEnv("AXHUB_TOKEN");
    AxHubClient client = AxHubClient.builder().baseUrl(base).token(token).tokenType(TokenType.PAT).defaultTenantId(tenantId).build();

    String suffix = Long.toUnsignedString(System.nanoTime());
    String appSlug = "sdke2e-java-" + suffix;
    String tableName = "items" + suffix.substring(suffix.length() - 8);

    List<Runnable> cleanups = new ArrayList<>();
    try {
      // --- identity: userId (grant principal + row owner) ---
      Map<String, Object> me = must(client, "me", "authGetApiV1Me", Map.of(), null);
      String userId = str(me, "id", "userId", "userID", "user_id");
      if (userId.isEmpty() && me.get("user") instanceof Map<?, ?> u) {
        userId = str(u, "id", "userId", "userID", "user_id");
      }
      if (userId.isEmpty()) throw new AssertionError("me: could not resolve user id from " + me.keySet());

      // --- app create (+ cleanup registered immediately) ---
      Map<String, Object> appRes = must(client, "create app", "appsPostApiV1TenantsByTenantIDApps",
          Map.of("tenantID", tenantId),
          Map.of("slug", appSlug, "name", "SDK destructive E2E " + suffix, "description", "sdke2e disposable"));
      String appId = str(appRes, "id", "appId", "appID");
      if (appId.isEmpty()) throw new AssertionError("create app: no id in response " + appRes.keySet());
      final String fAppId = appId;
      cleanups.add(() -> {
        try { client.request("appsDeleteApiV1AppsByAppID", Map.of("appID", fAppId), Map.of(), null); } catch (AxHubException ignored) {}
        try { client.request("appsDeleteApiV1AppsByAppIDPermanent", Map.of("appID", fAppId), Map.of(), null); } catch (AxHubException ignored) {}
      });

      // --- app update ---
      must(client, "update app", "appsPatchApiV1AppsByAppID", Map.of("appID", appId),
          Map.of("name", "SDK destructive E2E " + suffix + " renamed"));

      // --- env vars ---
      must(client, "set env var", "appsPostApiV1AppsByAppIDEnvVars", Map.of("appID", appId),
          Map.of("key", "SDK_E2E_SECRET", "value", "sekret-" + suffix));
      must(client, "delete env var", "appsDeleteApiV1AppsByAppIDEnvVarsByKey",
          Map.of("appID", appId, "key", "SDK_E2E_SECRET"), null);

      // --- comments ---
      Map<String, Object> cRes = must(client, "add comment", "appsPostApiV1AppsByAppIDComments", Map.of("appID", appId),
          Map.of("body", "sdke2e comment " + suffix));
      String commentId = str(cRes, "id", "commentId", "commentID");
      if (!commentId.isEmpty()) {
        must(client, "delete comment", "appsDeleteApiV1CommentsByCommentID", Map.of("commentID", commentId), null);
      }

      // --- likes (idempotent) ---
      must(client, "like", "appsPostApiV1AppsByAppIDLikes", Map.of("appID", appId), Map.of());
      must(client, "unlike", "appsDeleteApiV1AppsByAppIDLikes", Map.of("appID", appId), null);

      // --- icon upload url (signed URL; body key uncertain -> tolerate) ---
      tolerate(client, "icon upload url", "appsPostApiV1AppsByAppIDIconUploadUrl", Map.of("appID", appId),
          Map.of("content_type", "image/png"), 400, 404, 422);

      // --- tables: create -> add column -> grant -> rows CRUD -> revoke -> drop col -> delete ---
      must(client, "create table", "schemaPostApiV1AppsByAppIDTables", Map.of("appID", appId),
          Map.of(
              "table_name", tableName,
              "owner_column", "owner_id",
              "columns", List.of(
                  Map.of("name", "owner_id", "type", "uuid", "nullable", false),
                  Map.of("name", "title", "type", "text", "nullable", false),
                  Map.of("name", "status", "type", "text", "nullable", false),
                  Map.of("name", "metadata", "type", "jsonb", "nullable", true))));
      must(client, "add column", "schemaPostApiV1AppsByAppIDTablesByTableNameColumns",
          Map.of("appID", appId, "tableName", tableName),
          Map.of("column", Map.of("name", "priority", "type", "int", "nullable", true, "default", "0")));

      Map<String, Object> gRes = must(client, "add grant", "schemaPostApiV1AppsByAppIDTablesByTableNameGrants",
          Map.of("appID", appId, "tableName", tableName),
          Map.of("principal_type", "user", "principal_id", userId, "actions", List.of("read", "write")));
      String grantId = str(gRes, "id", "grantId", "grantID");

      // rows CRUD (node MISSES these)
      Map<String, Object> rRes = must(client, "insert row", "schemaPostApiV1AppsByAppIDTablesByTableNameRows",
          Map.of("appID", appId, "tableName", tableName),
          Map.of("owner_id", userId, "title", "row-" + suffix, "status", "active", "metadata", Map.of("k", "v")));
      String rowId = str(rRes, "id", "rowId", "rowID");
      if (!rowId.isEmpty()) {
        must(client, "update row", "schemaPatchApiV1AppsByAppIDTablesByTableNameRowsById",
            Map.of("appID", appId, "tableName", tableName, "id", rowId),
            Map.of("title", "row-" + suffix + "-updated"));
        must(client, "delete row", "schemaDeleteApiV1AppsByAppIDTablesByTableNameRowsById",
            Map.of("appID", appId, "tableName", tableName, "id", rowId), null);
      } else {
        throw new AssertionError("insert row: no id in response " + rRes.keySet());
      }

      if (!grantId.isEmpty()) {
        must(client, "revoke grant", "schemaDeleteApiV1AppsByAppIDTablesByTableNameGrantsByGrantID",
            Map.of("appID", appId, "tableName", tableName, "grantID", grantId), null);
      }
      must(client, "drop column", "schemaDeleteApiV1AppsByAppIDTablesByTableNameColumnsByColumnName",
          Map.of("appID", appId, "tableName", tableName, "columnName", "priority"), null);
      must(client, "delete table", "schemaDeleteApiV1AppsByAppIDTablesByTableName",
          Map.of("appID", appId, "tableName", tableName), null);

      // --- raw-db (node MISSES; body contract uncertain -> tolerate both POST + DELETE; app is disposable) ---
      tolerate(client, "raw-db exec", "appsPostApiV1AppsByAppIDRawDb", Map.of("appID", appId),
          Map.of("sql", "select 1"), 400, 403, 404, 409, 422, 501);
      tolerate(client, "raw-db reset", "appsDeleteApiV1AppsByAppIDRawDb", Map.of("appID", appId), null,
          400, 403, 404, 409, 422, 501);

      // --- oauth client (clientSecret surfaced once) ---
      Map<String, Object> ocRes = must(client, "create oauth client", "authPostApiV1AppsByAppIDOauthClients", Map.of("appID", appId),
          Map.of(
              "name", "SDK E2E OAuth " + suffix,
              "type", "confidential",
              "token_endpoint_auth_method", "client_secret_post",
              "redirect_uris", List.of("https://example.com/callback"),
              "allowed_scopes", List.of("read"),
              "allowed_grant_types", List.of("authorization_code", "refresh_token")));
      if (str(ocRes, "clientId", "client_id", "id").isEmpty() || str(ocRes, "clientSecret", "client_secret").isEmpty()) {
        throw new AssertionError("oauth client: missing clientId/clientSecret in " + ocRes.keySet());
      }

      // --- PAT lifecycle (account-scoped: explicit revoke, survives app deletion) ---
      Map<String, Object> patRes = must(client, "issue PAT", "schemaPostApiV1MePersonalAccessTokens", Map.of(),
          Map.of("name", "SDK E2E " + suffix, "expires_in_days", 1));
      String patId = str(patRes, "id", "patId", "patID");
      if (!patId.isEmpty()) {
        final String fPatId = patId;
        cleanups.add(() -> {
          try { client.request("schemaDeleteApiV1MePersonalAccessTokensByPatID", Map.of("patID", fPatId), Map.of(), null); } catch (AxHubException ignored) {}
        });
        if (str(patRes, "rawToken", "raw_token").isEmpty()) {
          throw new AssertionError("issue PAT: missing rawToken in " + patRes.keySet());
        }
        must(client, "revoke PAT", "schemaDeleteApiV1MePersonalAccessTokensByPatID", Map.of("patID", patId), null);
      }

      // --- publication: submit -> reject ; submit -> approve -> back to private (invite_only only, never public) ---
      Map<String, Object> p1 = must(client, "submit publication#1", "appsPostApiV1AppsByAppIDReviewRequests", Map.of("appID", appId),
          Map.of("reason", "sdke2e reject " + suffix, "requested_visibility", "invite_only"));
      String rr1 = str(p1, "id", "reviewRequestId", "rrId");
      if (!rr1.isEmpty()) {
        must(client, "reject publication#1", "appsPostApiV1ReviewRequestsByRrIDReject", Map.of("rrID", rr1),
            Map.of("comment", "sdke2e cleanup rejection"));
      }
      Map<String, Object> p2 = must(client, "submit publication#2", "appsPostApiV1AppsByAppIDReviewRequests", Map.of("appID", appId),
          Map.of("reason", "sdke2e approve " + suffix, "requested_visibility", "invite_only"));
      String rr2 = str(p2, "id", "reviewRequestId", "rrId");
      if (!rr2.isEmpty()) {
        must(client, "approve publication#2", "appsPostApiV1ReviewRequestsByRrIDApprove", Map.of("rrID", rr2),
            Map.of("comment", "sdke2e transient approval"));
        // unpublish equivalent: return app to private
        tolerate(client, "unpublish (visibility->private)", "appsPatchApiV1AppsByAppID", Map.of("appID", appId),
            Map.of("visibility", "private"), 400, 404, 409);
      }

      // --- TYPED-FAILURE: preconditions genuinely unavailable ---
      expectFail(client, "deployment create (no commit)", "deployPostApiV1AppsByAppIDDeployments", Map.of("appID", appId),
          Map.of("commit_sha", "a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6e7f8a9b0"), 400, 404, 409, 412);
      expectFail(client, "git connect (no install)", "deployPostApiV1AppsByAppIDGitGithubConnect", Map.of("appID", appId),
          Map.of("repo_full_name", "jocoding/sdke2e-nonexistent", "branch", "main", "installation_id", 0), 400, 403, 404, 409);
      tolerate(client, "access grant (self)", "appsPostApiV1AppsByAppIDAccess", Map.of("appID", appId), Map.of(), 400, 403, 409);

      // --- explicit teardown (cleanup stack also covers on failure) ---
      must(client, "delete app", "appsDeleteApiV1AppsByAppID", Map.of("appID", appId), null);
      must(client, "permanent delete app", "appsDeleteApiV1AppsByAppIDPermanent", Map.of("appID", appId), null);
      System.out.println("destructive lifecycle OK (app=" + appSlug + ")");
    } finally {
      // LIFO best-effort cleanup. Swallow Throwable so a cleanup error never masks the primary
      // failure — otherwise finally semantics would replace the in-flight exception and the run
      // would exit 0, hiding a real prod failure.
      for (int i = cleanups.size() - 1; i >= 0; i--) {
        try { cleanups.get(i).run(); } catch (Throwable ignored) {}
      }
    }
  }

  // must: member-mutable op that MUST succeed.
  private static Map<String, Object> must(AxHubClient c, String label, String opId, Map<String, String> pp, Object body) {
    try {
      Map<String, Object> res = c.request(opId, pp, Map.of(), body);
      System.out.println("  " + label + ": ok");
      return res;
    } catch (AxHubException e) {
      throw new AssertionError("MUST " + label + " (" + opId + "): " + e.status() + " " + e.code() + " " + e.getMessage(), e);
    }
  }

  // tolerate: precondition may be unavailable — accept success OR a typed AxHubException with an
  // allowed 4xx status; fail on 5xx/transport/other (status not in allowed).
  private static void tolerate(AxHubClient c, String label, String opId, Map<String, String> pp, Object body, int... allowed) {
    try {
      c.request(opId, pp, Map.of(), body);
      System.out.println("  " + label + ": ok (success)");
    } catch (AxHubException e) {
      if (!contains(allowed, e.status())) {
        throw new AssertionError("TOLERATE " + label + " (" + opId + "): status " + e.status() + " not in " + Arrays.toString(allowed) + " (" + e.code() + ")", e);
      }
      System.out.println("  " + label + ": ok (tolerated " + e.status() + ")");
    }
  }

  // expectFail: precondition genuinely unavailable — MUST return a typed 4xx in allowed.
  private static void expectFail(AxHubClient c, String label, String opId, Map<String, String> pp, Object body, int... allowed) {
    try {
      c.request(opId, pp, Map.of(), body);
      throw new AssertionError("EXPECTFAIL " + label + " (" + opId + "): expected typed failure, got success");
    } catch (AxHubException e) {
      if (!contains(allowed, e.status())) {
        throw new AssertionError("EXPECTFAIL " + label + " (" + opId + "): status " + e.status() + " not in " + Arrays.toString(allowed) + " (" + e.code() + ")", e);
      }
      System.out.println("  " + label + ": ok (expected-fail " + e.status() + ")");
    }
  }

  private static String str(Map<?, ?> m, String... keys) {
    for (String k : keys) {
      if (m.get(k) instanceof String s && !s.isBlank()) return s;
    }
    return "";
  }

  private static boolean contains(int[] xs, int x) {
    for (int v : xs) if (v == x) return true;
    return false;
  }

  private static String getenv(String key, String fallback) {
    String value = System.getenv(key);
    return value == null || value.isBlank() ? fallback : value;
  }

  private static String requireEnv(String key) {
    String value = System.getenv(key);
    if (value == null || value.isBlank()) throw new IllegalStateException(key + " is required");
    return value;
  }
}
