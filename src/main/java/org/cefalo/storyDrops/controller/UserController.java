package org.cefalo.storyDrops.controller;

import org.cefalo.storyDrops.model.User;
import org.cefalo.storyDrops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.*;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String createUser(@Valid @RequestBody User user){
        userRepository.save(user);
        return "Registration Successful";
    }
}
