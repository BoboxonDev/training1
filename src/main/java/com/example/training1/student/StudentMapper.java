package com.example.training1.student;

import com.example.training1.student.dto.RequestStudent;
import com.example.training1.student.dto.ResponseStudent;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

@Mapper(componentModel = SPRING)
public interface StudentMapper {

    StudentEntity toEntity(RequestStudent request);

    ResponseStudent toDto(StudentEntity student);

}
