package com.example.training1.level;


import com.example.training1.level.dto.LevelRequest;
import com.example.training1.level.dto.LevelResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

@Mapper(componentModel = SPRING)
public interface LevelMapper {

    LevelEntity toEntity(LevelRequest request);

    LevelResponse toDto(LevelEntity level);
}
