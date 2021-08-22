package com.csz.rest.service;

import com.csz.rest.model.User;
import com.csz.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> fetch(int uid) {
        return userRepository.findById(uid);
    }

}
