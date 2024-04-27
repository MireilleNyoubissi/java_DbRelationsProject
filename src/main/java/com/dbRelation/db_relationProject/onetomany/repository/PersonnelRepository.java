package com.dbRelation.db_relationProject.onetomany.repository;

import com.dbRelation.db_relationProject.onetomany.entities.Personnel;
import org.springframework.data.repository.CrudRepository;

public interface PersonnelRepository extends CrudRepository<Personnel, Long> {
}