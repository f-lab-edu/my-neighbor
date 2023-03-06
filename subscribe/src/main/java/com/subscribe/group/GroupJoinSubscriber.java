package com.subscribe.group;

import com.subscribe.dto.ConnectionDto;
import com.subscribe.model.Connection;
import com.subscribe.service.ConnectionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;

import static com.subscribe.mapper.ConnectionMapper.toEntity;

@Component
public class GroupJoinSubscriber {

    private final ConnectionService connectionService;

    private Connection result;

    public GroupJoinSubscriber(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @KafkaListener(topics = "${kafka.topic}", containerFactory = "groupKafkaListenerContainerFactory")
    public void groupJoinListener(ConnectionDto dto) {
        result = connectionService.saveConnection(toEntity(dto), LocalDateTime.now(Clock.systemDefaultZone()));
    }

    public Connection getResult() {
        return result;
    }
}
