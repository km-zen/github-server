package com.githubservertask.domain.service;

import com.githubservertask.domain.model.GitHubResult;
import com.githubservertask.domain.model.Owner;
import com.githubservertask.infrastructure.controller.dto.request.UserRequestDto;
import com.githubservertask.infrastructure.controller.dto.response.GetOwnReposFromUserResponse;

import java.util.List;

public class GitHubMapper {

    public static Owner mapFromUserRequestDtoToOwner(UserRequestDto request) {
        return new Owner(request.login());
    }

    public static GetOwnReposFromUserResponse mapFromGitHubResultListToGetOwnReposFromUserResponse(List<GitHubResult> repos) {
        return new GetOwnReposFromUserResponse(repos);
    }
}
