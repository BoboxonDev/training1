package com.example.training1.level;

import com.example.training1.level.dto.LevelRequest;
import com.example.training1.level.dto.LevelResponse;
import com.example.training1.student.dto.ResponseStudent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LevelServiceImpl implements LevelService{

    private final LevelRepository levelRepository;
    private final LevelMapper levelMapper;

    public LevelServiceImpl(LevelRepository levelRepository, LevelMapper levelMapper) {
        this.levelRepository = levelRepository;
        this.levelMapper = levelMapper;
    }

    @Override
    public void create(LevelRequest request) {
        var level = levelMapper.toEntity(request);
        level.setCreatedAt(LocalDateTime.now());
        level.setUpdatedAt(LocalDateTime.now());
        levelRepository.save(level);
    }

    @Override
    public List<LevelResponse> getAllLevel() {
        var levels = levelRepository.findAllByDeletedIsNull();
        List<LevelResponse> list = new ArrayList<>();

        levels.forEach(level -> {
            var dto = levelMapper.toDto(level);
            dto.setStudentId(level.getStudent().getId());
            var l = new ResponseStudent();
            l.setId(level.getStudent().getId());
            l.setFullName(level.getStudent().getFullName());
            l.setPhone(level.getStudent().getPhone());
            dto.setResponseStudent(l);
            list.add(dto);

        });
        return list;
    }

    @Override
    public LevelResponse getById(Long id) {
        var entity = levelRepository.findById(id).orElseThrow();
        var dto = levelMapper.toDto(entity);
        return dto;
    }

    @Override
    public void updateLevel(LevelRequest id) {

    }

    @Override
    public LevelResponse updateLevel(Long id, LevelRequest request) {
        var entity = levelRepository.findById(id).orElseThrow();
        entity.setName(request.getName());


        var updateEntity = levelRepository.save(entity);
        var dto = levelMapper.toDto(updateEntity);
        return dto;
    }

    @Override
    public LevelResponse deleteById(Long id) {
        var entity = levelRepository.findById(id).orElseThrow();
        entity.setDeletedAt(LocalDateTime.now());
        var dto = levelMapper.toDto(entity);
        levelRepository.save(entity);
        return dto;
    }
}
