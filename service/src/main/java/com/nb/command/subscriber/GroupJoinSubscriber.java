package com.nb.command.subscriber;

import com.nb.command.dto.ConnectionDto;
import com.nb.command.service.ConnectionService;
import com.nb.core.model.connection.Connection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;

import static com.nb.command.mapper.ConnectionMapper.toEntity;

@Slf4j
@Component
public class GroupJoinSubscriber {

    private final ConnectionService connectionService;

    private Connection result;

    public GroupJoinSubscriber(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @KafkaListener(topics = "${kafka.topic}", containerFactory = "groupKafkaListenerContainerFactory")
    public void groupJoinListener(ConnectionDto dto) {
        log.info("listener: {}", dto.toString());
        result = connectionService.saveConnection(toEntity(dto), LocalDateTime.now(Clock.systemDefaultZone()));
    }

    public Connection getResult() {
        return result;
    }
}
