package com.example.training1.student.dto;

import com.example.training1.level.dto.LevelResponse;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStudent {

    private Long id;

    private String fullName;

    private String phone;

    private List<LevelResponse> Level;
}
