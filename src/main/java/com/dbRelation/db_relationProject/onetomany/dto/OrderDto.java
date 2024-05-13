package com.dbRelation.db_relationProject.onetomany.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String orderDate;
    private Long customerId;
    private Long personnelId;

}
