package com.example.test.model.requestDTO;

import com.example.test.model.UserStatus;
import lombok.Data;

@Data
public class UserDto {
    String name;
    String surname;
    String email;
    String password;
    UserStatus userStatus;
}
