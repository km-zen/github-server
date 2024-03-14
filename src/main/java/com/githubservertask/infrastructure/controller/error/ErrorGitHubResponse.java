package com.githubservertask.infrastructure.controller.error;

import org.springframework.http.HttpStatusCode;

public record ErrorGitHubResponse(HttpStatusCode status, String message) {
}
