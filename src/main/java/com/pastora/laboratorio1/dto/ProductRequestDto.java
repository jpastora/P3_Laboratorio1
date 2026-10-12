package com.pastora.laboratorio1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data

public class ProductRequestDto {

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String name;
    private String description;

    @NotNull(message = "El precio del producto es obligatorio")
    @Min(value = 0, message = "El precio del producto debe ser mayor a 0")
    private BigDecimal price;

    @NotNull(message = "La cantidad en stock del producto es obligatoria")
    @Min(value = 0, message = "La cantidad en stock del producto debe ser mayor a 0")
    private Integer stockQuantity;

    @NotNull(message = "El ID de la categoría es obligatorio")
    private Long categoryId;

}
