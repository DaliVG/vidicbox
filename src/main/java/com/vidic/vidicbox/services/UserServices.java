package com.vidic.vidicbox.services;

import com.vidic.vidicbox.models.Users;
import com.vidic.vidicbox.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public List getAllUsers() {
        List usersList = new ArrayList();
        userRepository.findAll().forEach(user -> usersList.add(user));
        return usersList;
    }

    public Users getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public void saveOrUpdate(Users user) {
        userRepository.save(user);
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
