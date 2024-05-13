package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.manytomany.dto.AddEmployeeToProjectDto;
import com.dbRelation.db_relationProject.manytomany.entities.Employee;
import com.dbRelation.db_relationProject.manytomany.entities.Project;
import com.dbRelation.db_relationProject.onetomany.dto.*;
import com.dbRelation.db_relationProject.onetomany.entities.Customer;
import com.dbRelation.db_relationProject.onetomany.entities.Order;
import com.dbRelation.db_relationProject.onetomany.entities.Personnel;
import com.dbRelation.db_relationProject.onetomany.repository.CustomerRepository;
import com.dbRelation.db_relationProject.onetomany.repository.OrderRepository;
import com.dbRelation.db_relationProject.onetomany.repository.PersonnelRepository;
import com.dbRelation.db_relationProject.onetomany.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    PersonnelRepository personnelRepository;

    @Autowired
    SupplierRepository supplierRepository;

    //Endpoint to create an order

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setOrderDate(orderDto.getOrderDate());
        Customer customer = new Customer();
        customer.setId(orderDto.getCustomerId());
        order.setCustomer(customer);
        Personnel personnel = new Personnel();
        personnel.setId(orderDto.getPersonnelId());
        order.setPersonnel(personnel);
        return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
    }

    //Endpoint to add customer to order

    @PostMapping("customerId")
    public ResponseEntity<?> addCustomerToOrder(@PathVariable Long customerId, @RequestBody AddCustomerToOrderDto addCustomerToOrderDto) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            if(addCustomerToOrderDto.getOrderId() != null) {
                Optional<Order> orderOptional = orderRepository.findById(addCustomerToOrderDto.getOrderId());
                if(orderOptional.isPresent()) {
                    Order order = orderOptional.get();
                    order.setCustomer(customer);
                    return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
                }
            }
            return new ResponseEntity<>("Order doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Customer doesn't exist", HttpStatus.NOT_FOUND);
    }

    //Endpoint to add personnel to order

    @PostMapping("personnelId")
    public ResponseEntity<?> addPersonnelToOrder(@PathVariable Long personnelId, @RequestBody AddPersonnelToOrderDto addPersonnelToOrderDto) {
        Optional<Personnel> personnelOptional = personnelRepository.findById(personnelId);
        if(personnelOptional.isPresent()) {
            Personnel personnel = personnelOptional.get();
            if(addPersonnelToOrderDto.getOrderId() != null) {
                Optional<Order> orderOptional = orderRepository.findById(addPersonnelToOrderDto.getOrderId());
                if(orderOptional.isPresent()) {
                    Order order = orderOptional.get();
                    order.setPersonnel(personnel);
                    return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
                }
            }
            return new ResponseEntity<>("Order doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Personnel doesn't exist", HttpStatus.NOT_FOUND);
    }


    //Endpoint to get all orders

    @GetMapping
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        Iterable<Order> orders = orderRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    //Endpoint to get an order by id

    @GetMapping("{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()) {
            Order order = orderOptional.get();
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        return new ResponseEntity<>("Order doesn't exist", HttpStatus.NOT_FOUND);
    }

    //Endpoint to update an order
    @PutMapping("{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setOrderDate(orderDto.getOrderDate());
            return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
        }
        return new ResponseEntity<>("Order doesn't exist", HttpStatus.NOT_FOUND);
    }

    //Endpoint to delete an order
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()) {
            Order order = orderOptional.get();
            orderRepository.delete(order);
            return new ResponseEntity<>("Order has been deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Order doesn't exist", HttpStatus.NOT_FOUND);
    }

    //
    @GetMapping("customerNameWithOrderId")
    public ResponseEntity<List<CustomerNameWithOrderIdDto>> findCustomerNameWithOrderIdDto(){
        List<CustomerNameWithOrderIdDto> a = orderRepository.findCustomerNameWithOrderIdDto();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("personnelAgeWithOrderId")
    public ResponseEntity<List<PersonnelAgeWithOrderIdDto>> findPersonnelAgeWithOrderIdDto(){
        List<PersonnelAgeWithOrderIdDto> PersonnelAgeWithOrderDtoList = orderRepository.findPersonnelAgeWithOrderIdDto();
        return new ResponseEntity<>(PersonnelAgeWithOrderDtoList, HttpStatus.OK);
    }

    @GetMapping("customerCityWithOrderDto")
    public ResponseEntity<List<CustomerCityWithOrderDto>> findCustomerCityWithOrderDto(){
        List<CustomerCityWithOrderDto> CustomerCityWithOrderDtoList = orderRepository.findCustomerCityWithOrderDto();
        return new ResponseEntity<>(CustomerCityWithOrderDtoList, HttpStatus.OK);
    }

}


