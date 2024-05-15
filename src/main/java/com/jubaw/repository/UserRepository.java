package com.jubaw.repository;

import com.jubaw.domain.User;
import com.jubaw.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username) throws ResourceNotFoundException;

    Boolean existsByUserName(String username);



}
