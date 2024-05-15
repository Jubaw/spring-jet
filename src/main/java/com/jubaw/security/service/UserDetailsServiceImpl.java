package com.jubaw.security.service;

import com.jubaw.domain.User;
import com.jubaw.exception.ResourceNotFoundException;
import com.jubaw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username).orElseThrow(()->
                new ResourceNotFoundException("User not found with username : " + username));

        return UserDetailsImpl.build(user);
    }
}
