package com.x0nr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.x0nr.repository.UserRepository;

public class UserService implements UserDetailsService {


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("This user cannot be found"));
    }

    
    
}
