package ai.axhub.sdk;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class DeploymentsOperations {
  private final AxHubClient c;
  DeploymentsOperations(AxHubClient c) { this.c = c; }
  public Map<String, Object> deployGetApiV1AppsByAppIDDeployments(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1AppsByAppIDDeployments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1AppsByAppIDDeploymentsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1AppsByAppIDDeployments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPostApiV1AppsByAppIDDeployments(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPostApiV1AppsByAppIDDeployments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPostApiV1AppsByAppIDDeploymentsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPostApiV1AppsByAppIDDeployments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1AppsByAppIDDeploymentsByDid(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1AppsByAppIDDeploymentsByDid", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1AppsByAppIDDeploymentsByDidAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1AppsByAppIDDeploymentsByDid", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPostApiV1AppsByAppIDDeploymentsByDidCancel(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPostApiV1AppsByAppIDDeploymentsByDidCancel", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPostApiV1AppsByAppIDDeploymentsByDidCancelAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPostApiV1AppsByAppIDDeploymentsByDidCancel", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPostApiV1AppsByAppIDDeploymentsByDidRollback(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPostApiV1AppsByAppIDDeploymentsByDidRollback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPostApiV1AppsByAppIDDeploymentsByDidRollbackAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPostApiV1AppsByAppIDDeploymentsByDidRollback", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1AppsByAppIDDiagnosis(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1AppsByAppIDDiagnosis", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1AppsByAppIDDiagnosisAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1AppsByAppIDDiagnosis", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployDeleteApiV1AppsByAppIDGitConnection(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployDeleteApiV1AppsByAppIDGitConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployDeleteApiV1AppsByAppIDGitConnectionAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployDeleteApiV1AppsByAppIDGitConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1AppsByAppIDGitConnection(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1AppsByAppIDGitConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1AppsByAppIDGitConnectionAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1AppsByAppIDGitConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPatchApiV1AppsByAppIDGitConnection(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPatchApiV1AppsByAppIDGitConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPatchApiV1AppsByAppIDGitConnectionAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPatchApiV1AppsByAppIDGitConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPostApiV1AppsByAppIDGitConnection(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPostApiV1AppsByAppIDGitConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPostApiV1AppsByAppIDGitConnectionAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPostApiV1AppsByAppIDGitConnection", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPostApiV1AppsByAppIDGitGithubConnect(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPostApiV1AppsByAppIDGitGithubConnect", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPostApiV1AppsByAppIDGitGithubConnectAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPostApiV1AppsByAppIDGitGithubConnect", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1AppsByAppIDGitGithubInstallStart(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1AppsByAppIDGitGithubInstallStart", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1AppsByAppIDGitGithubInstallStartAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1AppsByAppIDGitGithubInstallStart", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1AppsByAppIDLogs(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1AppsByAppIDLogs", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1AppsByAppIDLogsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1AppsByAppIDLogs", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPostApiV1AppsByAppIDPromotionsByRequestIDRetry(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPostApiV1AppsByAppIDPromotionsByRequestIDRetry", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPostApiV1AppsByAppIDPromotionsByRequestIDRetryAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPostApiV1AppsByAppIDPromotionsByRequestIDRetry", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1AppsByAppIDReleases(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1AppsByAppIDReleases", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1AppsByAppIDReleasesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1AppsByAppIDReleases", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1AppsByAppIDReleasesPromotePreflight(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1AppsByAppIDReleasesPromotePreflight", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1AppsByAppIDReleasesPromotePreflightAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1AppsByAppIDReleasesPromotePreflight", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployDeleteApiV1AppsByAppIDStaging(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployDeleteApiV1AppsByAppIDStaging", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployDeleteApiV1AppsByAppIDStagingAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployDeleteApiV1AppsByAppIDStaging", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPutApiV1AppsByAppIDStaging(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPutApiV1AppsByAppIDStaging", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPutApiV1AppsByAppIDStagingAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPutApiV1AppsByAppIDStaging", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPostApiV1GitGithubComplete(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPostApiV1GitGithubComplete", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPostApiV1GitGithubCompleteAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPostApiV1GitGithubComplete", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1GithubAccounts(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1GithubAccounts", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1GithubAccountsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1GithubAccounts", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1GithubInstallationsByInstallationIDRepositories(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1GithubInstallationsByInstallationIDRepositories", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1GithubInstallationsByInstallationIDRepositoriesAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1GithubInstallationsByInstallationIDRepositories", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPostApiV1TenantsByTenantIDAppBootstraps(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPostApiV1TenantsByTenantIDAppBootstraps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPostApiV1TenantsByTenantIDAppBootstrapsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPostApiV1TenantsByTenantIDAppBootstraps", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1TenantsByTenantIDAppBootstrapsByBootstrapID(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1TenantsByTenantIDAppBootstrapsByBootstrapID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1TenantsByTenantIDAppBootstrapsByBootstrapIDAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1TenantsByTenantIDAppBootstrapsByBootstrapID", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployGetApiV1TenantsByTenantIDDeployments(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployGetApiV1TenantsByTenantIDDeployments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployGetApiV1TenantsByTenantIDDeploymentsAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployGetApiV1TenantsByTenantIDDeployments", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public Map<String, Object> deployPostWebhooksGithub(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.request("deployPostWebhooksGithub", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
  public CompletableFuture<Map<String, Object>> deployPostWebhooksGithubAsync(Map<String, String> pathParams, Map<String, String> query, Object body) {
    return c.requestAsync("deployPostWebhooksGithub", RouteOperations.map(pathParams), RouteOperations.map(query), body);
  }
}
