package com.api.event;

import com.api.dto.ConnectionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class GroupJoinPublisher {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, ConnectionDto> kafkaTemplate;

    public GroupJoinPublisher(KafkaTemplate<String, ConnectionDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(ConnectionDto dto) {
        CompletableFuture<SendResult<String, ConnectionDto>> future = kafkaTemplate.send(topic, dto).completable();

        future.whenComplete((result, ex) -> {
            ConnectionDto res = result.getProducerRecord().value();
            if (ex == null) {
                log.info("Sent message=[" + res.toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            else {
                log.warn( "Unable to send message=[" + res.toString() + "] due to : " + ex.getMessage());
            }
        });
    }
}
