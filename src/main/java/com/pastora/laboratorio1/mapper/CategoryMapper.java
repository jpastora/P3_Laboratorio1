package com.pastora.laboratorio1.mapper;

import com.pastora.laboratorio1.dto.CategoryRequestDto;
import com.pastora.laboratorio1.dto.CategoryResponseDto;
import com.pastora.laboratorio1.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CategoryMapper {

    Category toEntity(CategoryRequestDto dto);

    CategoryResponseDto toResponseDto(Category entity);

}
