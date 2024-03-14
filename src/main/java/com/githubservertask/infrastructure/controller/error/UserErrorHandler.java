package com.githubservertask.infrastructure.controller.error;


import com.githubservertask.infrastructure.controller.GitHubRepoRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = GitHubRepoRestController.class)
public class UserErrorHandler {


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorGitHubResponse handleException(UserNotFoundException exception) {
        return new ErrorGitHubResponse(exception.getStatusCode(), exception.getMessage());
    }
}
