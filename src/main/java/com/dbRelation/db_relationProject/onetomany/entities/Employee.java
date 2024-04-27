package com.dbRelation.db_relationProject.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity //Tels hibernate to create a table out of this class
@Table(name = "EMPLOYEE")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String birthDate;

    @Column
    private int age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "employeeId")
    private Set<Order> orders;
}
