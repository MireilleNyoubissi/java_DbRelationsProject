package com.dbRelation.db_relationProject.transaction.repository;

import com.dbRelation.db_relationProject.transaction.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.username like %?1%")
    public User findUserByUserName(String username);
}
