package com.nb.service.service;

import com.nb.core.model.connection.Connection;
import com.nb.core.repository.connection.ConnectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConnectionService {

    private final ConnectionRepository connectionRepository;

    @Transactional
    public Connection saveConnection(Connection connection, LocalDateTime now) {
        connection.updateCreateAt(now);
        return connectionRepository.save(connection);
    }
}
