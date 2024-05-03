package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.OrderDto;
import com.dbRelation.db_relationProject.onetomany.entities.Order;
import com.dbRelation.db_relationProject.onetomany.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    //Endpoint to create an order

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setOrderDate(orderDto.getOrderDate());
        return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
    }
}


