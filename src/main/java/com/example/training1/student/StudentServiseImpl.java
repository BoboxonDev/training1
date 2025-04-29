package com.example.training1.student;


import com.example.training1.level.LevelRepository;
import com.example.training1.level.dto.LevelResponse;
import com.example.training1.student.dto.RequestStudent;
import com.example.training1.student.dto.ResponseStudent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiseImpl implements StudentServise {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private final LevelRepository levelRepository;

    public StudentServiseImpl(StudentRepository studentRepository, StudentMapper studentMapper, LevelRepository levelRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.levelRepository = levelRepository;
    }

    @Override
    public void create(RequestStudent request) {
        var Student = studentMapper.toEntity(request);
        Student.setCreatedAt(LocalDateTime.now());
        Student.setUpdatedAt(LocalDateTime.now());
        studentRepository.save(Student);
    }

    @Override
    public List<ResponseStudent> getAll() {
        var students = studentRepository.findAllByDeleteIsNull();
        List<ResponseStudent> list = new ArrayList<>();

        students.forEach(student -> {
            var dto = studentMapper.toDto(student);

            var levels = levelRepository.findAllByLevelId(student.getId());
            List<LevelResponse> Llist = new ArrayList<>();

            if(levels!=null) {
                levels.forEach(level -> {
                    var L = studentMapper.toResponse(student);
                    Llist.add(L);
                });
            }

            dto.setLevel(Llist);
            list.add(dto);

        });


        return list;
    }

    @Override
    public ResponseStudent getById(Long id) {
        var entity = studentRepository.findById(id).orElseThrow();
        var dto = studentMapper.toDto(entity);
        return dto;
    }

    @Override
    public void updateStudent(RequestStudent id) {
    }

    @Override
    public ResponseStudent updateStudent(Long id, RequestStudent request) {
        var entity = studentRepository.findById(id).orElseThrow();
        entity.setFullname(request.getFullName());
        entity.setPhone(request.getPhone());

        var updateEntity = studentRepository.save(entity);
        var dto = studentMapper.toDto(updateEntity);
        return dto;
    }

    @Override
    public ResponseStudent deleteById(Long id) {
        var entity = studentRepository.findById(id).orElseThrow();
        entity.setDeletedAt(LocalDateTime.now());
        var dto = studentMapper.toDto(entity);
        studentRepository.save(entity);
        return dto;
    }
}
