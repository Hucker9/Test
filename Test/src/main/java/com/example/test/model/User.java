package com.example.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusers")
    private int idUsers;
    @Column (name = "name")
    private String name;
    @Column (name = "surname")
    private String surname;
    @Email
    @Column (name = "email")
    private String email;
    @Column (name = "password")
    private String password;
    @Column(name = "userstatus")
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;



}
