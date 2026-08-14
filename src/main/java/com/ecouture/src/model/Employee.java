package com.ecouture.src.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "first_name", nullable=false, length=50)
    private String firstName;

    @Column(name = "last_name", nullable=false, length=50)
    private String lastName;

    @Column(name = "email", unique=true, nullable=false, length=100)
    private String email;

    @Column(name = "phone_number", length=20)
    private String phoneNumber;

    @Column(name = "hire_date", nullable=false)
    private java.sql.Date hireDate;

    @Column(name = "job_title", length=50)
    private String jobTitle;

    @Column(name = "department", length=50)
    private String department;

    @Column(name = "salary")
    private java.math.BigDecimal salary;

    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "created_at", nullable=false)
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at", nullable=false)
    private java.sql.Timestamp updatedAt;
}
