package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.CustomerDto;
import com.dbRelation.db_relationProject.onetomany.entities.Customer;
import com.dbRelation.db_relationProject.onetomany.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    //Endpoint to create a customer

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setContactName(customerDto.getContactName());
        customer.setAddress(customerDto.getAddress());
        customer.setPostalCode(customerDto.getPostalCode());
        customer.setCity(customerDto.getCity());
        customer.setCountry(customerDto.getCountry());
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
    }


}
