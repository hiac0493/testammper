package com.example.testammper.repository;

import com.example.testammper.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<UsersEntity, UUID> {


    Optional<UsersEntity> findByUsername(String username);
}
