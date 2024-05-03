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

}


