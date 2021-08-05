package com.example.authentication.controller;

import com.example.authentication.model.User;
import com.example.authentication.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register() {
       return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser( @Valid @RequestBody User user) {
        String responseData = userService.createNewUser(user);
        return new ResponseEntity<>(responseData, HttpStatus.ACCEPTED);

    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User userReal = userService.getUserByEmail(user.getEmail());
        return userReal;
    }

}
