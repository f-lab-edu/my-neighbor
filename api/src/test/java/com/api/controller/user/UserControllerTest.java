package com.api.controller.user;

import com.api.model.user.User;
import com.api.service.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

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
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    @DisplayName("회원 가입 성공")
    public void test_join_isSuccess() throws Exception {
        // given
        JoinRequest request = new JoinRequest(email, name, password);
        given(userService.join(any(), any(), any())).willReturn(user);

        // when
        ResultActions result = mockMvc.perform(
            post("/api/user/join")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        result
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.response.userId").value(equalTo(userId.intValue())))
                .andExpect(jsonPath("$.error").value(IsNull.nullValue()));
    }

    @Test
    @DisplayName("사용자 조회 성공")
    public void test_getUser_isSuccess() throws Exception {
        // given
        when(userService.findById(anyLong())).thenReturn(Optional.ofNullable(user));

        // when
        ResultActions result = mockMvc.perform(
            get("/api/user/" + userId)
        );

        // then
        result
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.response.userId").value(equalTo(userId.intValue())))
                .andExpect(jsonPath("$.error").value(IsNull.nullValue()));
    }
}
