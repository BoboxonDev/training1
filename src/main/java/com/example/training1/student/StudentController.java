package com.example.training1.student;

import com.example.training1.student.dto.RequestStudent;
import com.example.training1.student.dto.ResponseStudent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentServise studentServise;

    public StudentController(StudentServise studentServise) {
        this.studentServise = studentServise;
    }

    @PostMapping
    ResponseEntity<Void> createStudent(@RequestBody RequestStudent request) {
        studentServise.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<List<ResponseStudent>> getStudents() {
       return ResponseEntity.ok(studentServise.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseStudent> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentServise.getById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody RequestStudent request) {
        studentServise.updateStudent(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentServise.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
