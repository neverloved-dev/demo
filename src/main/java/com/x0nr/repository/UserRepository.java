package com.x0nr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.x0nr.models.ApplicationUser;
import java.util.Optional;



@Repository
public interface UserRepository extends CrudRepository<ApplicationUser,Integer> {
    Optional<ApplicationUser> findByUsername(String username);
    
}
