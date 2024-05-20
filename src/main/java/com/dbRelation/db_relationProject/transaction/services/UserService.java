package com.dbRelation.db_relationProject.transaction.services;

import com.dbRelation.db_relationProject.transaction.entities.User;
import com.dbRelation.db_relationProject.transaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
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

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordEncoder = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoder);

        return userRepository.save(user);
    }

    public User getUserByUserName(String searchUserName) {
        return userRepository.findUserByUserName(searchUserName);
    }

    public boolean login(User user) {

        //
        User dbUser = userRepository.findUserByUserName(user.getUsername());
        if (dbUser != null ) {
            System.out.print("user " + dbUser.getUsername());
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String passwordEncoder = bCryptPasswordEncoder.encode(user.getPassword());

            if(bCryptPasswordEncoder.matches(user.getPassword(), dbUser.getPassword())){
                return true;
            }
        }

        return false;
    }


}
