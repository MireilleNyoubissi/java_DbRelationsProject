package com.dbRelation.db_relationProject.manytomany.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProject")
    private long id;

    private String projectName;

}
