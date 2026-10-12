package com.pastora.laboratorio1.mapper;

import com.pastora.laboratorio1.dto.ProductRequestDto;
import com.pastora.laboratorio1.dto.ProductResponseDto;
import com.pastora.laboratorio1.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})

public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    Product toEntity(ProductRequestDto dto);

    ProductResponseDto toResponseDto(Product entity);

}
