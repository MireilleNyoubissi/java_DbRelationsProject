package com.dbRelation.db_relationProject.onetomany.repository;

import com.dbRelation.db_relationProject.onetomany.dto.CustomerCityWithOrderDto;
import com.dbRelation.db_relationProject.onetomany.dto.CustomerNameWithOrderIdDto;
import com.dbRelation.db_relationProject.onetomany.dto.PersonnelAgeWithOrderIdDto;
import com.dbRelation.db_relationProject.onetomany.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT db_relationExple.order.id, db_relationExple.customer.customer_name\n" +
            "FROM db_relationExple.order\n" +
            "INNER JOIN db_relationExple.customer ON db_relationExple.order.customer_id = db_relationExple.customer.id", nativeQuery = true)
    public List<CustomerNameWithOrderIdDto> findCustomerNameWithOrderIdDto();

    @Query(value= "SELECT db_relationExple.order.id, db_relationExple.personnel.age From db_relationExple.order " +
            "INNER JOIN db_relationExple.personnel ON db_relationExple.order.personnel_id = db_relationExple.personnel.id", nativeQuery = true)
    public List<PersonnelAgeWithOrderIdDto> findPersonnelAgeWithOrderIdDto();

    @Query(value = "SELECT db_relationExple.order.id, db_relationExple.customer.city FROM db_relationExple.order " +
    "INNER JOIN db_relationExple.customer ON db_relationExple.order.customer_id = db_relationExple.customer.id", nativeQuery = true)
    public List<CustomerCityWithOrderDto> findCustomerCityWithOrderDto();



}
