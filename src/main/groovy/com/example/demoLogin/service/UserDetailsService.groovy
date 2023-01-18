package com.example.demoLogin.service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demoLogin.repository.UserRepository
import com.example.demoLogin.entity.User

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username);
        println "*"*100
        println(user.dump())
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;

    }

}
