package com.example.testammper.model.request.users;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
