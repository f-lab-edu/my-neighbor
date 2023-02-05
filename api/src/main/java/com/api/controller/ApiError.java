package com.api.controller;

import org.springframework.http.HttpStatus;

import java.util.StringJoiner;

public class ApiError {

    private String message;

    private int status;

    public ApiError(Throwable throwable, HttpStatus httpStatus) {
        this(throwable.getMessage(), httpStatus);
    }

    public ApiError(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ApiError.class.getSimpleName() + "[", "]")
                .add("status=" + status)
                .add("message='" + message + "'")
                .toString();
    }
}
