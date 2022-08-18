package com.example.kafkastream.service;

import com.example.kafkastream.config.KafkaMessageChannels;
import com.example.kafkastream.model.ApplicationBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.Map;

@Service
@Slf4j
public class KafkaPubService {
    private final KafkaMessageChannels kafkaMessageChannels;

    public KafkaPubService(KafkaMessageChannels kafkaMessageChannels) {
        this.kafkaMessageChannels = kafkaMessageChannels;
    }

    public void sendingMessage(final ApplicationBean applicationBean){
        log.info("Sending orderBean {}", applicationBean);
        kafkaMessageChannels.outputChannel()
            .send(MessageBuilder.withPayload(applicationBean)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
            .build());
    }
}
