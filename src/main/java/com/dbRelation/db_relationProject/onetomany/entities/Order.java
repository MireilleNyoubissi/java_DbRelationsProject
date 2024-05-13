package com.dbRelation.db_relationProject.onetomany.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity //Tells hibernate to create a table out of this class
@Table(name = "`ORDER`")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String orderDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnelId", nullable = false)
    private Personnel personnel;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ORDER_SUPPLIER", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "supplierId"))
    private Set<Supplier> suppliers;
}
