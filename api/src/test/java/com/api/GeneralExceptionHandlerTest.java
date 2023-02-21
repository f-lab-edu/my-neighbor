package com.api;

import com.api.controller.ApiResult;
import com.api.error.PostNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralExceptionHandlerTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    GeneralExceptionHandler handler;

    ResponseEntity<ApiResult<?>> res;

    PostNotFoundException e;

    @BeforeEach
    void setUp() {
        handler = new GeneralExceptionHandler();
        e = new PostNotFoundException();
    }

    @Test
    void test_handleNotFoundException () {
        res = handler.handleNotFoundException(e);
        log.info(Objects.requireNonNull(res.getBody()).getError().toString());

        assertEquals(res.getBody().getError().getStatus(), HttpStatus.NOT_FOUND.value());
        assertEquals(res.getBody().getError().getMessage(), e.getMessage());
    }
}
