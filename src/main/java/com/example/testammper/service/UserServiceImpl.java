package com.example.testammper.service;

import com.example.testammper.model.entity.UsersEntity;
import com.example.testammper.model.request.users.LoginRequest;
import com.example.testammper.model.request.users.SignUpRequest;
import com.example.testammper.repository.UsersRepository;
import com.example.testammper.utils.EncryptionMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    EncryptionMethods encryptionMethods;

    @Override
    public boolean login(LoginRequest request) {
        Optional<UsersEntity> optionalUser = usersRepository.findByUsername(request.getUsername());
        if (optionalUser.isPresent()) {
            UsersEntity user = optionalUser.get();
            return user.getPass().equals(encryptionMethods.encrypt(request.getPassword())) ? true : false;
        } else {
            return false;
        }
    }

    @Override
    public boolean addUser(SignUpRequest request) {
        Optional<UsersEntity> optionalUser = usersRepository.findByUsername(request.getUsername());
        if (optionalUser.isPresent()) {
            return false;
        }
        else {
            UsersEntity usersEntity = ServiceMapper.INSTANCE.toUserEntity(request);
            usersEntity.setPass(encryptionMethods.encrypt(request.getPass()));
            usersEntity.setCreatedAt(new Date());
            usersEntity.setActive(true);
            usersRepository.save(usersEntity);
            return true;
        }
    }
}
