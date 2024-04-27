package com.dbRelation.db_relationProject.onetomany.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDto {

    private String customerName;

    private String contactName;

    private String address;

    private String postalCode;

    private String city;

    private String country;
}
