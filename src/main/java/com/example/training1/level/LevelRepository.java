package com.example.training1.level;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.logging.Level;

public interface LevelRepository extends JpaRepository<LevelEntity, Long> {

    List<LevelEntity> findAllByDeleteIsNull();
}
