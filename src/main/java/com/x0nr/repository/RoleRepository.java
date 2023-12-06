package com.x0nr.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.x0nr.models.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
    Optional<Role> findByAuthority(String authority);
}
