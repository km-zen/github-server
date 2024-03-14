package com.githubservertask.infrastructure.controller.error;

import com.githubservertask.infrastructure.controller.GitHubRepoRestController;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = GitHubRepoRestController.class)
@Log4j2
public class GitHubErrorHandler {


}
