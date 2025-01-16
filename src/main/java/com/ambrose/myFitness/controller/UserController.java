package com.ambrose.myFitness.controller;

import com.ambrose.myFitness.model.User;
import com.ambrose.myFitness.service.FirebaseAuthService;
import com.ambrose.myFitness.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FirebaseAuthService firebaseAuthService;

//    @PostMapping("/register")
//    public User registerUser(@RequestBody User user) {
//        if (userService.userExists(user)){
//            throw new RuntimeException("User already exists.");
//        }
//        return userService.createUser(user);
//    }

    @GetMapping("/check-user")
    public String checkuser(@RequestHeader("Authorization") String authorizationHeader) {

        try {
            String idToken = authorizationHeader.replace("Bearer ", "");

            String uid = firebaseAuthService.verifyToken(idToken);

            User user = userService.getUserByUid(uid);
            return "User with UID: " + uid + " is authenticated.";
        } catch (Exception e) {
            return "Invalid token: " + e.getMessage();
        }
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
