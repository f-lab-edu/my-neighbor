package com.api;

import com.api.controller.ApiResult;
import com.api.error.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.api.controller.ApiResult.ERROR;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResult<?>> handleNotFoundException(NotFoundException e) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(ERROR(e, HttpStatus.NOT_FOUND), headers, HttpStatus.NOT_FOUND);
    }
}
