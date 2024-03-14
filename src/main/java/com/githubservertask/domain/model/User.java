package com.githubservertask.domain.model;

import java.util.List;

public record User(String login, List<Repo> repos) {
}
