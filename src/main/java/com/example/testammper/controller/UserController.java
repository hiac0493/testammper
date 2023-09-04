package com.example.testammper.controller;

import com.example.testammper.model.request.users.LoginRequest;
import com.example.testammper.model.request.users.SignUpRequest;
import com.example.testammper.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @Tag(name = "User")
    @Operation(summary = "Login", description = "Log in")
    @ApiResponse(responseCode = "200", description = "On Success")
    @PostMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest request){
        if(userService.login(request))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Tag(name = "User")
    @Operation(summary = "Sign up", description = "Create new user")
    @ApiResponse(responseCode = "200", description = "On Success")
    @PutMapping(value = "")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest request) {
        if (userService.addUser(request)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
