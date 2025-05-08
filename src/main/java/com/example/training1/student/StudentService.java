package com.example.training1.student;

import com.example.training1.student.dto.RequestStudent;
import com.example.training1.student.dto.ResponseStudent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void create(RequestStudent request);

    List<ResponseStudent> getAll();

    ResponseStudent getById(Long id);

    void updateStudent(RequestStudent id);

    ResponseStudent updateStudent(Long id, RequestStudent request);

    ResponseStudent deleteById(Long id);
}
