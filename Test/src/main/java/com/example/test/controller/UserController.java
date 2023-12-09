package com.example.test.controller;

import com.example.test.model.requestDTO.UserDto;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDto userDto){
        userService.create(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
