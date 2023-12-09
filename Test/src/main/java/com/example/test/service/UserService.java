package com.example.test.service;

import com.example.test.model.User;
import com.example.test.model.requestDTO.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void create(UserDto userDto);
    List<?> getAllUsers();
}
