package com.dbRelation.db_relationProject.onetomany.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SupplierDto {

    private String supplierName;

    private String contactName;

    private String address;

    private String postalCode;

    private String city;

    private String country;
}
