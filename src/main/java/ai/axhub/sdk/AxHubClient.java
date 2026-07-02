package ai.axhub.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public final class AxHubClient {
  private static final Gson GSON = new Gson();
  private static final Type MAP_TYPE = new TypeToken<LinkedHashMap<String, Object>>() {}.getType();

  private final String baseUrl;
  private final String token;
  private final String defaultTenantId;
  private final TokenType tokenType;
  private final HttpClient http;
  private final AppsClient apps;
  private final AppsOperations appsRoutes;
  private final IdentityOperations identity;
  private final TenantsOperations tenants;
  private final AuthzOperations authz;
  private final AuditOperations audit;
  private final GatewayOperations gateway;
  private final DataOperations data;
  private final DeploymentsOperations deployments;

  private AxHubClient(Builder b) {
    this.baseUrl = trim(b.baseUrl == null ? "https://api.axhub.ai" : b.baseUrl);
    this.token = b.token;
    this.tokenType = b.tokenType;
    this.defaultTenantId = b.defaultTenantId;
    if (b.http != null && b.http.followRedirects() != HttpClient.Redirect.NEVER) {
      throw new IllegalArgumentException("AxHubClient requires HttpClient.Redirect.NEVER to avoid auth header leakage on redirects");
    }
    this.http = b.http == null ? HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NEVER).build() : b.http;
    this.apps = new AppsClient(this);
    this.appsRoutes = new AppsOperations(this);
    this.identity = new IdentityOperations(this);
    this.tenants = new TenantsOperations(this);
    this.authz = new AuthzOperations(this);
    this.audit = new AuditOperations(this);
    this.gateway = new GatewayOperations(this);
    this.data = new DataOperations(this);
    this.deployments = new DeploymentsOperations(this);
  }

  public static Builder builder() { return new Builder(); }
  public AppsClient apps() { return apps; }
  public AppsOperations appsRoutes() { return appsRoutes; }
  public IdentityOperations identity() { return identity; }
  public TenantsOperations tenants() { return tenants; }
  public AuthzOperations authz() { return authz; }
  public AuditOperations audit() { return audit; }
  public GatewayOperations gateway() { return gateway; }
  public DataOperations data() { return data; }
  public DeploymentsOperations deployments() { return deployments; }
  public String baseUrl() { return baseUrl; }
  public String redactedToken() { return token == null || token.isBlank() ? "" : "***REDACTED***"; }

  public static final class Builder {
    private String baseUrl, token, defaultTenantId;
    private TokenType tokenType;
    private HttpClient http;
    public Builder baseUrl(String v) { baseUrl = v; return this; }
    public Builder token(String v) { token = v; return this; }
    public Builder tokenType(TokenType v) { tokenType = v; return this; }
    public Builder defaultTenantId(String v) { defaultTenantId = v; return this; }
    public Builder http(HttpClient v) { http = v; return this; }
    public AxHubClient build() { return new AxHubClient(this); }
  }

  public static final class AppsClient {
    private final AxHubClient c;
    private AppsClient(AxHubClient c) { this.c = c; }
    public Map<String, Object> create(Map<String, ?> body) {
      if (c.defaultTenantId == null || c.defaultTenantId.isBlank()) {
        throw new AxHubException("tenant_id_required", "tenant_id_required", "default tenant id is required", 0, false);
      }
      return c.request("appsPostApiV1TenantsByTenantIDApps", Map.of("tenantID", c.defaultTenantId), Map.of(), body);
    }
    public CompletableFuture<Map<String, Object>> createAsync(Map<String, ?> body) {
      return CompletableFuture.supplyAsync(() -> create(body));
    }
  }

  public Map<String, Object> request(String operationId, Map<String, String> pathParams, Map<String, String> query, Object body) {
    Route route = Routes.byOperation(operationId);
    String path = route.path();
    for (var e : pathParams.entrySet()) path = path.replace("{" + e.getKey() + "}", enc(e.getValue()));
    if (path.contains("{")) throw new AxHubException("validation", "required", "missing path parameter", 0, false);
    String url = baseUrl + path;
    if (!query.isEmpty()) {
      StringBuilder q = new StringBuilder();
      for (var e : query.entrySet()) {
        if (q.length() > 0) q.append('&');
        q.append(enc(e.getKey())).append('=').append(enc(e.getValue()));
      }
      url += "?" + q;
    }
    HttpRequest.Builder rb = HttpRequest.newBuilder(URI.create(url)).header("X-Request-ID", requestId());
    if (token != null && !token.isBlank()) {
      if (tokenType == TokenType.PAT) rb.header("X-Api-Key", token);
      else if (tokenType == TokenType.JWT) rb.header("Authorization", "Bearer " + token);
      else throw new AxHubException("validation", "required", "tokenType must be explicit", 0, false);
    }
    String rawBody = body == null ? "" : GSON.toJson(body);
    if (body != null) {
      rb.header("Content-Type", "application/json");
    }
    rb.method(route.method(), body == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(rawBody));
    try {
      HttpResponse<String> res = http.send(rb.build(), HttpResponse.BodyHandlers.ofString());
      if (res.statusCode() >= 300 && res.statusCode() < 400) {
        Map<String, Object> redirect = new LinkedHashMap<>();
        redirect.put("status", res.statusCode());
        redirect.put("location", res.headers().firstValue("Location").orElse(null));
        return redirect;
      }
      if (res.statusCode() >= 400) throw parseError(res.statusCode(), res.body());
      Map<String, Object> parsed = Json.parseObject(res.body());
      return Json.camelize(parsed);
    } catch (IOException e) {
      throw new AxHubException("network", "network_error", e.getMessage(), 0, true);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new AxHubException("network", "interrupted", e.getMessage(), 0, true);
    }
  }

  public CompletableFuture<Map<String, Object>> requestAsync(String operationId, Map<String, String> pathParams, Map<String, String> query, Object body) {
    return CompletableFuture.supplyAsync(() -> request(operationId, pathParams, query, body));
  }

  private static AxHubException parseError(int status, String body) {
    String code = "http_" + status;
    String category = null;
    String message = null;
    String requestId = null;
    Boolean retryable = null;
    try {
      JsonElement parsed = JsonParser.parseString(body == null || body.isBlank() ? "{}" : body);
      if (parsed.isJsonObject()) {
        JsonObject root = parsed.getAsJsonObject();
        JsonObject err = root.has("error") && root.get("error").isJsonObject() ? root.getAsJsonObject("error") : root;
        code = stringOr(err, "code", code);
        category = stringOr(err, "category", null);
        message = stringOr(err, "message", null);
        requestId = stringOr(err, "request_id", stringOr(err, "requestId", null));
        if (err.has("retryable") && !err.get("retryable").isJsonNull()) retryable = err.get("retryable").getAsBoolean();
      }
    } catch (RuntimeException ignored) {
      // Non-JSON error bodies still become typed HTTP errors below.
    }
    ErrorInfo info = ErrorCodes.ALL.get(code);
    if (category == null) category = info == null ? "unknown" : info.category();
    boolean finalRetryable = retryable != null ? retryable : info != null && info.retryable();
    return new AxHubException(category, code, message, status, finalRetryable, requestId);
  }

  private static String stringOr(JsonObject obj, String key, String fallback) {
    return obj.has(key) && !obj.get(key).isJsonNull() ? obj.get(key).getAsString() : fallback;
  }
  private static String trim(String s) { return s.endsWith("/") ? s.substring(0, s.length() - 1) : s; }
  private static String enc(String s) { return URLEncoder.encode(s, StandardCharsets.UTF_8).replace("+", "%20"); }
  private static String requestId() { return (Instant.now().toEpochMilli() + UUID.randomUUID().toString().replace("-", "")).substring(0, 26); }

  static final class Json {
    static Map<String, Object> parseObject(String json) {
      Map<String, Object> out = new LinkedHashMap<>();
      if (json == null || json.isBlank()) return out;
      try {
        JsonElement parsed = JsonParser.parseString(json);
        if (parsed.isJsonObject()) {
          Map<String, Object> obj = GSON.fromJson(parsed, MAP_TYPE);
          return obj == null ? out : obj;
        }
        if (parsed.isJsonArray()) out.put("value", GSON.fromJson(parsed, Object.class));
        else if (parsed.isJsonPrimitive()) out.put("value", GSON.fromJson(parsed, Object.class));
        else out.put("value", null);
        return out;
      } catch (RuntimeException ignored) {
        out.put("raw", json);
        return out;
      }
    }
    static Map<String, Object> camelize(Map<String, Object> in) {
      Map<String, Object> out = new LinkedHashMap<>();
      for (var e : in.entrySet()) out.put(camel(e.getKey()), camelizeValue(e.getValue()));
      return out;
    }
    @SuppressWarnings("unchecked")
    static Object camelizeValue(Object value) {
      if (value instanceof Map<?, ?> m) return camelize((Map<String, Object>) m);
      if (value instanceof List<?> list) return list.stream().map(Json::camelizeValue).toList();
      return value;
    }
    static String camel(String s) {
      StringBuilder b = new StringBuilder();
      boolean up = false;
      for (char c : s.toCharArray()) {
        if (c == '_') { up = true; continue; }
        b.append(up ? Character.toUpperCase(c) : c);
        up = false;
      }
      return b.toString();
    }
  }
}
