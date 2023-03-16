package com.nb.api.service.connection;

import com.nb.core.model.connection.Connection;
import com.nb.core.model.group.Group;
import com.nb.core.model.user.User;
import com.nb.core.repository.connection.ConnectionRepository;
import com.nb.core.repository.group.GroupRepository;
import com.nb.core.repository.user.UserRepository;
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
