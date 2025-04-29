package com.example.training1.student;


import com.example.training1.student.dto.RequestStudent;
import com.example.training1.student.dto.ResponseStudent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiseImpl implements StudentServise {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiseImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public void create(RequestStudent request) {
        var Student = studentMapper.toEntity(request);
        studentRepository.save(Student);
    }

    @Override
    public List<ResponseStudent> getAll() {
        return null;
    }

    @Override
    public ResponseStudent getById(Long id) {
        return null;
    }

    @Override
    public void updateStudent(RequestStudent id) {

    }

    @Override
    public ResponseStudent updateStudent(Long id, RequestStudent request) {
        return null;
    }

    @Override
    public ResponseStudent deleteById(Long id) {
        return null;
    }



}
