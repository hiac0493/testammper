package com.example.testammper.service;

import com.example.testammper.model.request.users.LoginRequest;
import com.example.testammper.model.request.users.SignUpRequest;

public interface UserService {
    boolean login(LoginRequest request);
    boolean addUser(SignUpRequest request);
}
