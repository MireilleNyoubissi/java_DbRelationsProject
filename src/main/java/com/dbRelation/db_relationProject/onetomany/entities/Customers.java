package com.dbRelation.db_relationProject.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity //Tels hibernate to create a table out of this class
@Table(name = "CUSTOMERS")
@Data
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String customerName;

    @Column
    private String contactName;

    @Column
    private String address;

    @Column
    private String postalCode;

    @Column
    private String city;

    @Column
    private String country;

    @OneToMany
    @JoinColumn(name = "customerId")
    private Set<Order> orders;


}
