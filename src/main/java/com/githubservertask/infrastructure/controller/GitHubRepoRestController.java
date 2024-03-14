package com.githubservertask.infrastructure.controller;

import com.githubservertask.domain.model.GitHubResult;
import com.githubservertask.domain.model.Owner;
import com.githubservertask.domain.service.GitHubMapper;
import com.githubservertask.domain.service.GithubService;
import com.githubservertask.infrastructure.controller.dto.request.UserRequestDto;
import com.githubservertask.infrastructure.controller.dto.response.GetOwnReposFromUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/repos")
public class GitHubRepoRestController {
    private final GithubService gitHubService;

    public GitHubRepoRestController(GithubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/{request}")
    public ResponseEntity<GetOwnReposFromUserResponse> getRepoMap(@PathVariable UserRequestDto request) {
        Owner owner = GitHubMapper.mapFromUserRequestDtoToOwner(request);
        List<GitHubResult> repos = gitHubService.findAllReposByUserLoginWithBranches(owner.login());
        GetOwnReposFromUserResponse body = GitHubMapper.mapFromGitHubResultListToGetOwnReposFromUserResponse(repos);

        return ResponseEntity.ok(body);
    }
}
