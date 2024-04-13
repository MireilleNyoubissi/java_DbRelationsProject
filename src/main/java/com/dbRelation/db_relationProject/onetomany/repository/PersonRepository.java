package com.dbRelation.db_relationProject.onetomany.repository;

import com.dbRelation.db_relationProject.onetomany.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
