package com.example.kafkastream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEnrolInfo implements Serializable {
    private String customerId;
    private String offerId;
    private String accountNumber;
}
