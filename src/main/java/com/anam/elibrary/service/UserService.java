package com.anam.elibrary.service;

import com.anam.elibrary.entity.User;
import com.anam.elibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
//        return userRepository.findAll();
    }
}
