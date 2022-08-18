package com.example.kafkastream.config;

import static com.example.kafkastream.constants.ApplicationConstants.INPUT_CHANNEL;
import static com.example.kafkastream.constants.ApplicationConstants.OUTPUT_CHANNEL;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaMessageChannels {

    @Input(INPUT_CHANNEL)
    SubscribableChannel inputChannel();

    @Output(OUTPUT_CHANNEL)
    MessageChannel outputChannel();
}
