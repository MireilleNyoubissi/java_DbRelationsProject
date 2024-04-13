package com.dbRelation.db_relationProject.onetomany.repository;

import com.dbRelation.db_relationProject.onetomany.entities.House;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<House, Long> {
}
