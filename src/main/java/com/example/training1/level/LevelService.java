package com.example.training1.level;

import com.example.training1.level.dto.LevelRequest;
import com.example.training1.level.dto.LevelResponse;

import java.util.List;

public interface LevelService {

    void create(LevelRequest request);

    List<LevelResponse> getAllLevel();

    LevelResponse getById(Long id);

    void updateLevel(LevelRequest id);

    LevelResponse updateLevel(Long id, LevelRequest request);

    LevelResponse deleteById(Long id);
}
