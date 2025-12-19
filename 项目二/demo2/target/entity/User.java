package com.example.demo.entity;

import lombok.Data;
import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullName;
    private String role;
    private Date createdTime;
    private Date updatedTime;
}