package com.example.training1.student.dto;

import com.example.training1.level.dto.LevelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestStudent {
    private String fullName;

    private String phone;

    private List<LevelResponse> Level;
}
