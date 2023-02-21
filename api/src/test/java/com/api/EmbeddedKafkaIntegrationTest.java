package com.api;

import com.api.dto.ConnectionDto;
import com.api.event.GroupJoinPublisher;
import com.api.event.GroupJoinSubscriber;
import com.api.model.connection.Connection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class EmbeddedKafkaIntegrationTest {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private GroupJoinPublisher pub;

    @Autowired
    private GroupJoinSubscriber sub;

    ConnectionDto connectionDto;

    Connection connection;

    @Value("${test.topic}")
    private String topic;

    @BeforeEach
    void setUp() {
        connectionDto = new ConnectionDto(1L, 2L);
    }

    @Test
    public void givenEmbeddedKafkaBroker_whenSendingWithConnectionDto_thenConnectionReceived() throws Exception {
        pub.publish(connectionDto);
        boolean messageConsumed = sub.getLatch().await(2, TimeUnit.SECONDS);
        assertTrue(messageConsumed);

        connection = sub.getResult();
        assertNotNull(connection.getConnectionId());
        assertEquals(connectionDto.getGroupId(), connection.getGroupId());
        assertEquals(connectionDto.getUserId(), connection.getUserId());
        assertNotNull(connection.getCreateAt());
    }
}
