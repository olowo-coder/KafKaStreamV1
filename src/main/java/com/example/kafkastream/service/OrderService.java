package com.example.kafkastream.service;

import com.example.kafkastream.model.ApplicationBean;
import com.example.kafkastream.model.CustomerEnrolInfo;
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

    public Map<String , String > sendOrder(CustomerEnrolInfo customerEnrolInfo){
        kafkaPubService.sendingMessage(new ApplicationBean(UUID.randomUUID().toString(),
            "order-event", System.currentTimeMillis(), customerEnrolInfo));
        return Map.of("status", "Send Successful");
    }
}
