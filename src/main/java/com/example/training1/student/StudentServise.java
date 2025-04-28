package com.example.training1.student;

import com.example.training1.student.dto.RequestStudent;
import com.example.training1.student.dto.ResponseStudent;

import java.util.List;

public interface StudentServise {
    void create(RequestStudent request);

    List<ResponseStudent> getAll();

    ResponseStudent getById(Long id);

    void updateStudent(RequestStudent id);

    ResponseStudent updateStudent(Long id, RequestStudent request);

    ResponseStudent deleteById(Long id);
}
