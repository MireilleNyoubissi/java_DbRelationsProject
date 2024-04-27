package com.dbRelation.db_relationProject.onetomany.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PersonnelDto {

    private String firstName;

    private String lastName;

    private String birthDate;

    private int age;
}
