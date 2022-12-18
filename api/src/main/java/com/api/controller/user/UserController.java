package com.api.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {

    // 내 정보 조회
    @GetMapping("me")
    public Object me() {
        return null;
    }

    // 회원 가입
    @PostMapping("join")
    public Object join() {
        return null;
    }
}
