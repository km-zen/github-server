package com.githubservertask.domain.service;

import com.githubservertask.domain.model.Branch;
import com.githubservertask.domain.model.GitHubResult;
import com.githubservertask.domain.model.Repo;
import com.githubservertask.domain.proxy.GitHubProxy;
import com.githubservertask.infrastructure.controller.error.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GithubService {

    GitHubProxy gitHubProxy;

    public GithubService(GitHubProxy gitHubProxy) {
        this.gitHubProxy = gitHubProxy;
    }

    public List<Repo> findAllReposByUserLogin(String login) {
        try {
            List<Repo> reposFromUser = gitHubProxy.getReposFromUser(login);
            return reposFromUser;
        } catch (HttpClientErrorException exception) {
            throw new UserNotFoundException("User: " + login + "NOT FOUND");
        }
    }

    public List<Branch> getBranchesFromRepo(String login, String repoName) {
        return gitHubProxy.getBranchesFromRepo(login, repoName);
    }

    public List<GitHubResult> findAllReposByUserLoginWithBranches(String login) {
        List<Repo> repos = findAllReposByUserLogin(login);
        List<GitHubResult> resultList = new ArrayList<>();
        for (Repo repo : repos) {
            GitHubResult gitHubResult = new GitHubResult(repo, getBranchesFromRepo(login, repo.name()));
            resultList.add(gitHubResult);
        }
        return resultList;
    }

}
