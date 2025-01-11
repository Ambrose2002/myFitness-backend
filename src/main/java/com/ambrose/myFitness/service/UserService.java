package com.ambrose.myFitness.service;

import com.ambrose.myFitness.model.User;
import com.ambrose.myFitness.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean userExists(User user) {
        return userRepository.findByUsername(user.getUsername()) != null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
