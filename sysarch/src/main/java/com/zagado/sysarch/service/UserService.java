package com.zagado.sysarch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zagado.sysarch.model.User;
import com.zagado.sysarch.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String login(String username, String password) {

        if (username == null || password == null) {
            return "Message: Either username or password is null";
        }

        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return "Message: Invalid Credentials";
        }

        return "Message: Log in successfully";
    }
}
