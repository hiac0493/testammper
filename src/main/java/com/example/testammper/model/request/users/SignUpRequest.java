package com.example.testammper.model.request.users;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String name;
    private String lastname;
    private String pass;
}
