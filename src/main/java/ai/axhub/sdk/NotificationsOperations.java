package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class NotificationsOperations {
  private final AxHubClient c;
  NotificationsOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> notificationsPostApiV1AppMails(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("notificationsPostApiV1AppMails", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> notificationsPostApiV1AppMailsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("notificationsPostApiV1AppMails", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> notificationsPostApiV1AppNotifications(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("notificationsPostApiV1AppNotifications", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> notificationsPostApiV1AppNotificationsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("notificationsPostApiV1AppNotifications", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> notificationsGetApiV1MeNotifications(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("notificationsGetApiV1MeNotifications", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> notificationsGetApiV1MeNotificationsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("notificationsGetApiV1MeNotifications", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> notificationsPostApiV1MeNotificationsByNotificationIDRead(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("notificationsPostApiV1MeNotificationsByNotificationIDRead", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> notificationsPostApiV1MeNotificationsByNotificationIDReadAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("notificationsPostApiV1MeNotificationsByNotificationIDRead", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> notificationsPostApiV1MeNotificationsReadAll(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("notificationsPostApiV1MeNotificationsReadAll", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> notificationsPostApiV1MeNotificationsReadAllAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("notificationsPostApiV1MeNotificationsReadAll", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
