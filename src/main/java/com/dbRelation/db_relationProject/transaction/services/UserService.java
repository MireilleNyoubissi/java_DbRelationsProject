package com.dbRelation.db_relationProject.transaction.services;

import com.dbRelation.db_relationProject.transaction.entities.User;
import com.dbRelation.db_relationProject.transaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}