package com.dbRelation.db_relationProject.transaction.repository;

import com.dbRelation.db_relationProject.transaction.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
