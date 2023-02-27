package com.api.event;

import com.api.dto.ConnectionDto;
import com.api.model.connection.Connection;
import com.api.service.connection.ConnectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

import static com.api.controller.connection.ConnectionMapper.toEntity;

@Component
public class GroupJoinSubscriber {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private CountDownLatch latch = new CountDownLatch(1);

    private final ConnectionService connectionService;

    private Connection result;

    public GroupJoinSubscriber(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @KafkaListener(topics = "${kafka.topic}", containerFactory = "groupKafkaListenerContainerFactory")
    public void groupJoinListener(ConnectionDto dto) {
        result = connectionService.saveConnection(toEntity(dto));
        latch.countDown();
    }

    public Connection getResult() {
        return result;
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
