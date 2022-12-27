package com.api.service.user;

import com.api.model.user.User;
import com.api.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Mock
    UserRepository userRepository;

    private Long userId;

    private String name;

    private String email;

    private String password;

    private User user;

    @BeforeAll
    void setUp() {
        userId = 1L;
        name = "yuna";
        email = "yuna@gmail.com";
        password = "pw123";

        user = new User(userId, email, name, password, null, null, null, null, now());
    }

    @Test
    void 사용자를_생성한다() {
        when(userRepository.insert(any(User.class))).thenReturn(user);

        UserService userService = new UserService(userRepository);
        User result = userService.join(email, name, password);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getEmail()).isEqualTo(email);
    }

    @Test
    void 사용자를_아이디로_조회한다() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        UserService userService = new UserService(userRepository);
        User result = userService.findById(userId).orElse(null);

        log.info("user: {}", result);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getEmail()).isEqualTo(email);
    }

    @Test
    void 사용자를_아이디로_조회할수없다() {

        Long undefinedId = 20L;
        String message = "not found";
        when(userRepository.findById(undefinedId)).thenThrow(new RuntimeException(message));

        UserService userService = new UserService(userRepository);
        RuntimeException e = assertThrows(RuntimeException.class, () -> userService.findById(undefinedId));

        assertThat(e.getMessage()).isEqualTo(message);
    }
}
