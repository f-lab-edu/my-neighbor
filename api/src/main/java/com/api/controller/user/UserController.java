package com.api.controller.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    // 내 정보 조회
    @GetMapping("me")
    public Object me() {
        return "{\n" +
                "   \"success\" : true, \n" +
                "   \"response\": [\n" +
                "       {\n" +
                "           \"userId\": 125, \n" +
                "           \"email\": \"user125@gmail.com\", \n" +
                "           \"name\": \"kim user\", \n" +
                "           \"cityId\": 2, \n" +
                "           \"townId\": 5, \n" +
                "           \"profileImageUrl\": \"https://s3.console.aws.amazon.com/......jpeg\", \n" +
                "           \"lastLoginAt\": \"2022-03-20\", \n" +
                "           \"createAt\": \"2021-02-15\" \n" +
                "       } \n" +
                "   ], \n" +
                "   \"length\" : 1, \n" +
                "   \"error\" : null \n" +
                "}";
    }

    // 특정 사용자 조회
    @GetMapping("{userId}")
    public Object getOneUser(@PathVariable Long userId) {
        return "{\n" +
                "   \"success\" : true, \n" +
                "   \"response\": [\n" +
                "       {\n" +
                "           \"userId\": " + userId + ", \n" +
                "           \"email\": \"test_user@gmail.com\", \n" +
                "           \"name\": \"lee user\", \n" +
                "           \"cityId\": 8, \n" +
                "           \"townId\": 11, \n" +
                "           \"profileImageUrl\": \"https://s3.console.aws.amazon.com/......jpeg\", \n" +
                "           \"lastLoginAt\": \"2022-12-20\", \n" +
                "           \"createAt\": \"2020-05-26\" \n" +
                "       } \n" +
                "   ], \n" +
                "   \"length\" : 1, \n" +
                "   \"error\" : null \n" +
                "}";
    }

    // 회원 가입
    @PostMapping("join")
    public Object join() {
        return "{\n" +
                "   \"success\" : true, \n" +
                "   \"response\": [\n" +
                "       {\n" +
                "           \"userId\": 522, \n" +
                "           \"email\": \"park@gmail.com\", \n" +
                "           \"name\": \"park user\", \n" +
                "           \"cityId\": 1, \n" +
                "           \"townId\": 2, \n" +
                "           \"profileImageUrl\": \"https://s3.console.aws.amazon.com/......jpeg\", \n" +
                "           \"lastLoginAt\": \"2022-03-20\", \n" +
                "           \"createAt\": \"2021-02-15\" \n" +
                "       } \n" +
                "   ], \n" +
                "   \"length\" : 1, \n" +
                "   \"error\" : null \n" +
                "}";
    }
}
