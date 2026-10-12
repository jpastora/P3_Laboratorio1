package com.pastora.laboratorio1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class CategoryRequestDto {

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    private String name;

    private String description;

}
