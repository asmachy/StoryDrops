package com.example.authentication.service;

import com.example.authentication.model.LoginUserDetails;
import com.example.authentication.model.User;
import com.example.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    public String createNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Registration Successful";
    }


    public User getUserByEmail(String email) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElseThrow(()-> new UsernameNotFoundException("Incorrect email or password"));
    }

    public boolean isEmailAvailable(String email){
        return userRepository.findByEmail(email).orElse(null) != null;
    }

    @Override
    public LoginUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(LoginUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("Incorrect email or password"));
    }
}