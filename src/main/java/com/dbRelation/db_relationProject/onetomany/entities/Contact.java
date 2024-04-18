package com.dbRelation.db_relationProject.onetomany.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity //This tells hibernate to create a table out of this class
@Table(name = "CONTACT")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String tel;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;
}
