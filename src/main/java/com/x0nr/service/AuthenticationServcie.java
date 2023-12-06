package com.x0nr.service;

import java.util.HashSet;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x0nr.models.ApplicationUser;
import com.x0nr.models.Role;
import com.x0nr.repository.RoleRepository;
import com.x0nr.repository.UserRepository;

@Service
@Transactional
public class AuthenticationServcie {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public ApplicationUser registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new ApplicationUser(0,encodedPassword,username,authorities));
    }
}
