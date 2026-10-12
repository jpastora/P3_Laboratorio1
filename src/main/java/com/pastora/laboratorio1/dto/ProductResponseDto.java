package com.pastora.laboratorio1.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data

public class ProductResponseDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private CategoryResponseDto category;

}
