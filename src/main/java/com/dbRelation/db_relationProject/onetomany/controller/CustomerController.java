package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.CustomerDto;
import com.dbRelation.db_relationProject.onetomany.entities.Customer;
import com.dbRelation.db_relationProject.onetomany.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    //Endpoint to get all customers

    @GetMapping
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //Endpoint to get a customer by id

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>("customer doesn't exist", HttpStatus.NOT_FOUND);
    }

}
