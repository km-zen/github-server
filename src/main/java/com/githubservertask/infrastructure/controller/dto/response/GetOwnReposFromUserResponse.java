package com.githubservertask.infrastructure.controller.dto.response;

import com.githubservertask.domain.model.GitHubResult;

import java.util.List;

public record GetOwnReposFromUserResponse(List<GitHubResult> repos) {
}
