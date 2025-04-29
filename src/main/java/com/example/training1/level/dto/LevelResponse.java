package com.example.training1.level.dto;

import com.example.training1.student.dto.ResponseStudent;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LevelResponse {
    private Long id;

    private String name;

    @NotNull
    private Long studentId;

    private ResponseStudent responseStudent;
}
