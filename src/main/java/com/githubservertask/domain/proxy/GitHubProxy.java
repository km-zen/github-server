package com.githubservertask.domain.proxy;

import com.githubservertask.domain.model.Branch;
import com.githubservertask.domain.model.Repo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "github-api")
public interface GitHubProxy {

    @GetMapping("/users/{user}/repos")
    List<Repo> getReposFromUser(@PathVariable String user);

    @GetMapping("/repos/{login}/{repo_name}/branches")
    List<Branch> getBranchesFromRepo(@PathVariable String login, @PathVariable String repo_name);
}
