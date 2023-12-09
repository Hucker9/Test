package com.example.test.service.serviceIMPL;

import com.example.test.model.User;
import com.example.test.model.requestDTO.UserDto;
import com.example.test.model.response.UserResponseDto;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import com.example.test.util.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(UserDto userDto) {
        User user = new User();
        user.setIdUsers(0);
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserStatus(userDto.getUserStatus());
        userRepository.save(user);
    }

    public List<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDTOS = new ArrayList<>();
        for (User user : users) {
            UserResponseDto userDTO = new UserResponseDto();
            userDTO.setName(user.getName());
            userDTO.setSurname(user.getSurname());
            userResponseDTOS.add(userDTO);
        }
        return userResponseDTOS;
    }

}
