package com.api.controller.user;

import com.api.controller.ApiResult;
import com.api.dto.JoinRequest;
import com.api.dto.UserDto;
import com.api.model.user.User;
import com.api.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

class UserControllerTest {

    UserController userController;

    @Mock
    private UserService userService;

    private Long userId;

    private String name;

    private String email;

    private String password;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        userId = 1L;
        name = "yuna";
        email = "yuna@gmail.com";
        password = "pw123";
        user = new User(userId, email, name, password, null, null, null, null, now());

        userController = new UserController(userService);
    }

    @Test
    @DisplayName("회원 가입 성공")
    public void test_join_isSuccess() {
        // given
        JoinRequest request = new JoinRequest(email, name, password);
        given(userService.join(any(), any(), any())).willReturn(user);

        // when
        ApiResult<UserDto> joinResult = userController.join(request);

        // then
        assertThat(joinResult).isNotNull();
        assertThat(joinResult.isSuccess()).isTrue();
        assertThat(joinResult.getResponse().getUserId()).isEqualTo(userId);
        assertThat(joinResult.getError()).isNull();
    }

    @Test
    @DisplayName("사용자 조회 성공")
    public void test_getUser_isSuccess() {
        // given
        when(userService.findById(anyLong())).thenReturn(Optional.ofNullable(user));

        // when
        ApiResult<UserDto> userResult = userController.getUser(userId);

        // then
        assertThat(userResult).isNotNull();
        assertThat(userResult.isSuccess()).isTrue();
        assertThat(userResult.getResponse().getUserId()).isEqualTo(userId);
        assertThat(userResult.getError()).isNull();
    }
}
