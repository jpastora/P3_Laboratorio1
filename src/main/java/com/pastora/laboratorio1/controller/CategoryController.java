package com.pastora.laboratorio1.controller;

import com.pastora.laboratorio1.dto.CategoryRequestDto;
import com.pastora.laboratorio1.dto.CategoryResponseDto;
import com.pastora.laboratorio1.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER-ADMIN-ROLE')")
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto requestDto) {
        return new ResponseEntity<>(categoryService.createCategory(requestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER-ADMIN-ROLE')")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryRequestDto requestDto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, requestDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER-ADMIN-ROLE')")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
