package com.example.training1.level.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LevelRequest {
    private String name;

    @NotNull
    private Long studentId;
}
