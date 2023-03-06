package com.api.service.connection;

import com.api.model.connection.Connection;
import com.api.model.group.Group;
import com.api.model.user.User;
import com.api.repository.connection.ConnectionRepository;
import com.api.repository.group.GroupRepository;
import com.api.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

class ConnectionServiceTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    ConnectionService connectionService;

    @Mock
    ConnectionRepository connectionRepository;

    @Mock
    GroupRepository groupRepository;

    @Mock
    UserRepository userRepository;

    Connection conn;

    Connection resConn;

    @Mock
    Group group;

    @Mock
    User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        connectionService = new ConnectionService(connectionRepository, groupRepository, userRepository);
        conn = new Connection(1L, 2L);
        resConn = new Connection(5L, 1L, 2L, LocalDateTime.now());
    }
}
