package com.nb.service.subscriber;

import com.nb.service.dto.ConnectionDto;
import com.nb.service.service.ConnectionService;
import com.nb.core.model.connection.Connection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;

import static com.nb.service.mapper.ConnectionMapper.toEntity;

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
