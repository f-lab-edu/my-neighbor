package com.api;

import com.api.controller.ApiResult;
import com.api.error.GroupNotFoundException;
import com.api.error.PostNotFoundException;
import com.api.error.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.api.controller.ApiResult.ERROR;

@RestControllerAdvice
public class GeneralExceptionHandler {

    private ResponseEntity<ApiResult<?>> newResponse(Throwable throwable, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(ERROR(throwable, status), headers, status);
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
