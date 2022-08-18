package com.example.kafkastream.config;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(KafkaMessageChannels.class)
public class StreamsConfig {
}
