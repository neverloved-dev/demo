package com.x0nr.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.x0nr.dto.RegisterDTO;
import com.x0nr.models.ApplicationUser;
import com.x0nr.service.AuthenticationServcie;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationServcie authenticationServcie;

    @PostMapping("/register")
    public ApplicationUser registerUApplicationUser(@RequestBody RegisterDTO body) {
            return authenticationServcie.registerUser(body.getUsername(), body.getPassword());
    }
        
}
