package com.example.training1.student.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ResponseStudent {

    private Long id;

    private String fullName;

    private String phone;

    private String asdl;
}
