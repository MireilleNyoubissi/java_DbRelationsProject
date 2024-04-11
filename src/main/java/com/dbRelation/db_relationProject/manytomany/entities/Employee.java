package com.dbRelation.db_relationProject.manytomany.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity //This tells Hibernate to make a table out of this class
@Data
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idEmp")
    private int id;

    private String name;

    private String email;

}
