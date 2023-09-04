package com.example.testammper.repository;

import com.example.testammper.model.entity.BanksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BanksRepository extends JpaRepository<BanksEntity, String> {

    Optional<BanksEntity> findById(int id);
}
