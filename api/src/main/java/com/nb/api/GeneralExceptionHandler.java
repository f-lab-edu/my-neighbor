package com.nb.api;

import com.nb.api.controller.ApiResult;
import com.nb.core.error.GroupNotFoundException;
import com.nb.core.error.PostNotFoundException;
import com.nb.core.error.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    private ResponseEntity<ApiResult<?>> newResponse(Throwable throwable, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(ApiResult.ERROR(throwable, status), headers, status);
    }

    @ExceptionHandler({UserNotFoundException.class, GroupNotFoundException.class, PostNotFoundException.class})
    public ResponseEntity<ApiResult<?>> handleNotFoundException(RuntimeException e) {
        return newResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<?> handleException(Exception e) {
        return newResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
