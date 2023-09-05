package com.anam.elibrary.service;

import com.anam.elibrary.entity.User;
import com.anam.elibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public int save(User user) {
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return userRepository.save(user);
    }

    public int deleteById(int id) {
        return userRepository.deleteById(id);
    }

    public int update(User user) {
        user.setUpdatedAt(new Date());
        return userRepository.update(user);
    }

}
