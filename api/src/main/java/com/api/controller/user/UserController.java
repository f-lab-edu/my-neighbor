package com.api.controller.user;

import com.api.controller.ApiResult;
import com.api.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.api.controller.ApiResult.OK;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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
    public ApiResult<UserDto> getUser(@PathVariable Long userId) {
        return OK(
            userService.findById(userId)
                    .map(UserDto::new)
                    .orElseThrow(RuntimeException::new)
        );
    }

    // 회원 가입
    @PostMapping("join")
    public ApiResult<UserDto> join(@RequestBody JoinRequest request) {
        return OK(
            new UserDto(userService.join(request.getPrincipal(), request.getName(), request.getCredentials()))
        );
    }
}
