package com.dbRelation.db_relationProject.manytomany.controller;

import com.dbRelation.db_relationProject.manytomany.entities.Employee;
import com.dbRelation.db_relationProject.manytomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee _employee = employeeRepository.save(employee);
        return new ResponseEntity<>(_employee, HttpStatus.CREATED);
    }

}