package com.dbRelation.db_relationProject.manytomany.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProject")
    private long id;

    private String projectName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLOYEE_PROJECT", joinColumns = @JoinColumn(name = "idProject"), inverseJoinColumns = @JoinColumn(name = "idEmployee"))
    private Set<Employee> Employees;

}
