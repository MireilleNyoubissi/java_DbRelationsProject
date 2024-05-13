package com.dbRelation.db_relationProject.transaction.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountNumber;
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
