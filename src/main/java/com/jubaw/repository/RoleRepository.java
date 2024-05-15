package com.jubaw.repository;

import com.jubaw.domain.Role;
import com.jubaw.domain.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(UserRole name);

}
