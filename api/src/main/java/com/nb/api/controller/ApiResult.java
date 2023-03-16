package com.nb.api.controller;

import org.springframework.http.HttpStatus;

import java.util.StringJoiner;

public class ApiResult<T> {

    private boolean success;

    private T response;

    private ApiError error;

    private ApiResult(boolean success, T response, ApiError error) {
        this.success = success;
        this.response = response;
        this.error = error;
    }

    public static <T> ApiResult<T> Ok(T response) {
        return new ApiResult<>(true, response, null);
    }

    public static ApiResult<?> ERROR(Throwable throwable, HttpStatus status) {
        return new ApiResult<>(false, null, new ApiError(throwable, status));
    }

    public static ApiResult<?> ERROR(String errorMessage, HttpStatus status) {
        return new ApiResult<>(false, null, new ApiError(errorMessage, status));
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResponse() {
        return response;
    }

    public ApiError getError() {
        return error;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ApiResult.class.getSimpleName() + "[", "]")
                .add("success=" + success)
                .add("response=" + response)
                .add("error=" + error)
                .toString();
    }
}
