package com.example.training1.student;

import com.example.training1.level.dto.LevelResponse;
import com.example.training1.student.dto.RequestStudent;
import com.example.training1.student.dto.ResponseStudent;
import org.mapstruct.Mapper;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

@Mapper(componentModel = SPRING)
public interface StudentMapper {

    StudentEntity toEntity(RequestStudent request);

    ResponseStudent toDto(StudentEntity student);

    LevelResponse toResponse(StudentEntity level);
}
