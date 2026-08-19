package com.ecouture.src.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "account_name", nullable=false, length = 25)
    private String accountName;

    @Column(name = "account_type", nullable = false, length = 25)
    private String accountType;

    @Column(name = "account_number", nullable = false)
    private Integer accounNumber;

}
