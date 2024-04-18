package com.dbRelation.db_relationProject.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity //This tells Hibernate to make a table out of this class
@Data
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;


    private String personName;
    private String personEmail;

    @OneToMany
    @JoinColumn(name = "personId")
    private Set<House> houses;

    @OneToMany
    @JoinColumn(name = "personId")
    private Set<Contact> contacts;

}
