package com.jubaw.controller;

import com.jubaw.dto.LoginRequest;
import com.jubaw.dto.RegisterRequest;
import com.jubaw.security.JwtUtils;
import com.jubaw.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
@AllArgsConstructor

public class UserJwtController {
    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    // Not: Register *************************************
    @PostMapping("/register") // http://localhost:8080/register + POST + JSON
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request){

        userService.registerUser(request);
        String responseMessage = "User registered Successfully";

        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    // Not: Login ******************************************
    @PostMapping("/login") // http://localhost:8080/login + POST + JSON
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

        String token = jwtUtils.generateToken(authentication);
        Map<String,String> map = new HashMap<>();
        map.put("token", token);
        map.put("status", "true");

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
