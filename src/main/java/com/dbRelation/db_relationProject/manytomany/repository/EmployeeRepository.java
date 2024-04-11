package com.dbRelation.db_relationProject.manytomany.repository;

import com.dbRelation.db_relationProject.manytomany.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
