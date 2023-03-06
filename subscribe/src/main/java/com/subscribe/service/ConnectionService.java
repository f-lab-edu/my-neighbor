package com.subscribe.service;

import com.subscribe.model.Connection;
import com.subscribe.repository.ConnectionRepository;
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
