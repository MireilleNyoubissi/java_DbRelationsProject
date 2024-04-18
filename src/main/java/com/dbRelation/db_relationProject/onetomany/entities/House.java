package com.dbRelation.db_relationProject.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity //This tells Hibernate to make a table out of this class
@Data
@Table(name = "HOUSE")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;


}
