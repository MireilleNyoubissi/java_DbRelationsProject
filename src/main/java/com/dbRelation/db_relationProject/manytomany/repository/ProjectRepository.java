package com.dbRelation.db_relationProject.manytomany.repository;

import com.dbRelation.db_relationProject.manytomany.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
