package com.dbRelation.db_relationProject.manytomany.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity //This tells Hibernate to make a table out of this class
@Data
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idEmployee")
    private long id;

    private String name;

    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLOYEE_PROJECT", joinColumns = @JoinColumn(name = "idEmployee"), inverseJoinColumns = @JoinColumn(name = "idProject"))
    private Set<Project> projects;

}
