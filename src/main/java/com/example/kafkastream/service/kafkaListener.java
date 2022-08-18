package com.example.kafkastream.service;

import com.example.kafkastream.model.ApplicationBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.example.kafkastream.constants.ApplicationConstants.INPUT_CHANNEL;

@Component
@Slf4j
public class kafkaListener {
    @StreamListener(INPUT_CHANNEL)
    public void handleOrders(@Payload ApplicationBean applicationBean) {
        log.info("Received orders: {}", applicationBean);
    }
}
