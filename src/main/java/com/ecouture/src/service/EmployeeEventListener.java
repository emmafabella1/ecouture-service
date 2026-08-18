package com.ecouture.src.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventListener {

    @KafkaListener(topics = "employee-fetch-events", groupId = "employee-group")
    public void consume(String message) {
        System.out.println("Kafka event received: " + message);
    }
}