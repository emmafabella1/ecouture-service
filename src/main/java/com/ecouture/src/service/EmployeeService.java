package com.ecouture.src.service;

import com.ecouture.src.model.Employee;
import com.ecouture.src.repository.EmployeeRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.employeeRepository = employeeRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final String TOPIC = "employee-fetch-events";

    private final KafkaTemplate<String, String> kafkaTemplate;
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        String message = "Employees fetched: " + employees.size() + " at " + Instant.now();
        kafkaTemplate.send(TOPIC, message);

        return employees;
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
