package com.api.service.connection;

import com.api.error.GroupNotFoundException;
import com.api.error.UserNotFoundException;
import com.api.model.connection.Connection;
import com.api.model.group.Group;
import com.api.model.user.User;
import com.api.repository.connection.ConnectionRepository;
import com.api.repository.group.GroupRepository;
import com.api.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ConnectionServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ConnectionService connectionService;

    @Mock
    ConnectionRepository connectionRepository;

    @Mock
    GroupRepository groupRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    private Clock clock;

    Connection conn;

    Connection resConn;

    @Mock
    Group group;

    @Mock
    User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        String fixedTime = "2023-01-22T10:05:23.653Z";
        when(clock.instant()).thenReturn(Instant.parse(fixedTime));
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());

        connectionService = new ConnectionService(connectionRepository, groupRepository, userRepository, clock);
        conn = new Connection(1L, 2L);
        resConn = new Connection(5L, 1L, 2L, LocalDateTime.now(clock));
    }

    @Test
    void 커넥션을_생성한다() {
        when(connectionRepository.save(any(Connection.class))).thenReturn(resConn);
        when(groupRepository.findById(any())).thenReturn(Optional.ofNullable(group));
        when(userRepository.findById(any())).thenReturn(Optional.ofNullable(user));

        Connection res = connectionService.saveConnection(conn);

        assertThat(res.getCreateAt()).isEqualTo(LocalDateTime.now(clock));
    }
}
