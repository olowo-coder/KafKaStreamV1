package com.example.kafkastream.service;

import com.example.kafkastream.config.KafkaMessageChannels;
import com.example.kafkastream.model.BeanApp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class KafkaPubService {
    private final KafkaMessageChannels kafkaMessageChannels;

    public KafkaPubService(KafkaMessageChannels kafkaMessageChannels) {
        this.kafkaMessageChannels = kafkaMessageChannels;
    }

    public void sendingMessage(final BeanApp beanApp){
        log.info("Sending orderBean {}", beanApp);
        kafkaMessageChannels.outputChannel()
            .send(MessageBuilder.withPayload(beanApp)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
            .build());
    }
}
