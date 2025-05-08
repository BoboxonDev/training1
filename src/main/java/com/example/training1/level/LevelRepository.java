package com.example.training1.level;

import com.example.training1.student.StudentEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;

@Repository
public interface LevelRepository extends JpaRepository<LevelEntity, Long> {

    @Query("SELECT s FROM LevelEntity s WHERE s.student.id = :levelId")
    List<LevelEntity> findAllByLevelId(@Param("levelId") Long levelId);

    List<LevelEntity> findAllByDeletedIsNull();
}
