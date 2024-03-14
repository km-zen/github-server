package com.githubservertask.domain.model;

import java.util.List;

public class GitHubResult {
    private Repo repo;
    private List<Branch> branches;

    public GitHubResult(Repo repo, List<Branch> branches) {
        this.repo = repo;
        this.branches = branches;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
