package com.example.elo7.repository;

import com.example.elo7.entity.SpacecraftEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpacecraftRepository extends JpaRepository<SpacecraftEntity, String> {

    SpacecraftEntity findByNameSpacecraft(String nameSpacecraft);
}
