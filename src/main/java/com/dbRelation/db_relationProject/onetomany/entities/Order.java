package com.dbRelation.db_relationProject.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity //Tells hibernate to create a table out of this class
@Table(name = "ORDER")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String orderDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "customerId")
    private Customer customer;

    
}
