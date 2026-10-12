package com.pastora.laboratorio1.service;

import com.pastora.laboratorio1.dto.CategoryRequestDto;
import com.pastora.laboratorio1.dto.CategoryResponseDto;
import com.pastora.laboratorio1.mapper.CategoryMapper;
import com.pastora.laboratorio1.model.Category;
import com.pastora.laboratorio1.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        Category category = categoryMapper.toEntity(requestDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDto(savedCategory);
    }

    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto requestDto) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + id));

        existingCategory.setName(requestDto.getName());
        existingCategory.setDescription(requestDto.getDescription());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toResponseDto(updatedCategory);
    }

    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Categoría no encontrada con ID: " + id);
        }
        categoryRepository.deleteById(id);
    }
}
