package com.api.controller.authentication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationRestController {

    // 로그인
    @PostMapping
    public Object authentication() {
        return null;
    }
}
