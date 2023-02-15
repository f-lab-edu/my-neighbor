package com.api.controller.user;

import com.api.controller.ApiResult;
import com.api.dto.JoinRequest;
import com.api.dto.UserDto;
import com.api.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.api.controller.ApiResult.Ok;
import static com.api.controller.user.UserMapper.toDto;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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
        return Ok(
            userService.findById(userId)
                    .map(UserMapper::toDto)
                    .orElseThrow(RuntimeException::new)
        );
    }

    // 회원 가입
    @PostMapping("join")
    public ApiResult<UserDto> join(@RequestBody JoinRequest request) {
        return Ok(
            toDto(
                userService.join(request.getPrincipal(), request.getName(), request.getCredentials())
            )
        );
    }
}
