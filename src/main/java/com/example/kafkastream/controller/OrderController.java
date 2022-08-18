package com.example.kafkastream.controller;

import com.example.kafkastream.model.CustomerEnrolInfo;
import com.example.kafkastream.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> sendOrder(@RequestBody final CustomerEnrolInfo info){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.sendOrder(info));
    }

    @GetMapping
    public ResponseEntity<?> test(){
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("test", "executed"));
    }
}
