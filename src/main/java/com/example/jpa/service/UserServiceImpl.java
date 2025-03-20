package com.example.jpa.service;

import com.example.jpa.dto.UserDto;
import com.example.jpa.entity.User;
import com.example.jpa.mapper.UserMapper;
import com.example.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public void addUser(UserDto userDto) {
        User user = mapper.toUser(userDto);
        repository.save(user);
    }

    @Override
    public List<User> findByAgeGreaterThan(int age) {
        return repository.findByAgeGreaterThan(age);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<User> findUsersOlderThan(int age) {
        return repository.findUsersOlderThan(age);
    }
}
