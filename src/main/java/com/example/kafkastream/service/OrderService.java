package com.example.kafkastream.service;

import com.example.kafkastream.model.BeanApp;
import com.example.kafkastream.model.InfoDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    private final KafkaPubService kafkaPubService;

    @Autowired
    public OrderService(KafkaPubService kafkaPubService) {
        this.kafkaPubService = kafkaPubService;
    }

    public Map<String , String > sendOrder(InfoDisplay infoDisplay){
        kafkaPubService.sendingMessage(new BeanApp(UUID.randomUUID().toString(),
            "order-event", System.currentTimeMillis(), infoDisplay));
        return Map.of("status", "Send Successful");
    }
}
