package com.akd.taskmanagement.service;

import com.akd.taskmanagement.dto.UserDto;
import com.akd.taskmanagement.entity.AppUser;
import com.akd.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto register(UserDto user) {
        AppUser newAppUser = new AppUser(user.getUsername(), user.getPassword());
        userRepository.save(newAppUser);
        return user;
    }
    
    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }
}
