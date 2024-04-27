package com.dbRelation.db_relationProject.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity //Tels hibernate to create a table out of this class
@Table(name = "SUPPLIER")
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String supplierName;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ORDER_SUPPLIER", joinColumns = @JoinColumn(name = "supplier_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orders;
}
