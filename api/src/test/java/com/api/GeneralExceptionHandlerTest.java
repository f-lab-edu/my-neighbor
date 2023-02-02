package com.api;

import com.api.controller.ApiResult;
import com.api.error.NotFoundException;
import com.api.model.group.Group;
import com.api.util.MessageUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GeneralExceptionHandlerTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    GeneralExceptionHandler handler;

    ResponseEntity<ApiResult<?>> res;

    @Autowired
    MessageSourceAccessor messageSourceAccessor;

    NotFoundException e;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        handler = new GeneralExceptionHandler();
        e = new NotFoundException(Group.class, 1L);
    }

    @Test
    void test_handleNotFoundException () {
        MessageUtils.setMessageSourceAccessor(messageSourceAccessor);

        res = handler.handleNotFoundException(e);
        log.info(Objects.requireNonNull(res.getBody()).getError().toString());

        assertEquals(res.getBody().getError().getStatus(), HttpStatus.NOT_FOUND.value());
        assertEquals(res.getBody().getError().getMessage(), e.getMessage());
    }
}
