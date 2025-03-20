package com.example.jpa.service;

import com.example.jpa.dto.UserDto;
import com.example.jpa.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void addUser(UserDto userDto);
    public List<User> findByAgeGreaterThan(int age);
    Optional<User> findByUsername(String username);
    public List<User> findUsersOlderThan(int age);
}
