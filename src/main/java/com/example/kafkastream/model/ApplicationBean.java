package com.example.kafkastream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationBean {

    private String uuid;
    private String eventName;
    private long timeStamp;
    private CustomerEnrolInfo customerEnrolInfo;
}
