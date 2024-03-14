package com.githubservertask.infrastructure.controller.error;

import com.githubservertask.infrastructure.controller.GitHubRepoRestController;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = GitHubRepoRestController.class)
@Log4j2
public class MediaTypeErrorHandler {


    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorGitHubResponse handleException(HttpMediaTypeNotAcceptableException exception) {
        log.error("Wrong Media Type!");
        return new ErrorGitHubResponse(exception.getStatusCode(), exception.getMessage());
    }

}
