package com.ambrose.myFitness.service;

import com.ambrose.myFitness.model.User;
import com.ambrose.myFitness.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    public boolean userExists(User user) {
        return userRepository.findByUsername(user.getUsername()).isPresent();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUid(String uid) {
        return userRepository.findByUid(uid)
                .orElseThrow(() -> new RuntimeException("User not found with uid: " + uid));
    }
}
