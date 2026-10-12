package com.pastora.laboratorio1.service;

import com.pastora.laboratorio1.dto.ProductRequestDto;
import com.pastora.laboratorio1.dto.ProductResponseDto;
import com.pastora.laboratorio1.mapper.ProductMapper;
import com.pastora.laboratorio1.model.Category;
import com.pastora.laboratorio1.model.Product;
import com.pastora.laboratorio1.repository.CategoryRepository;
import com.pastora.laboratorio1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Category category = categoryRepository.findById(requestDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("No se puede crear el producto, ya que la categoría no se encuentra: "));
        Product product = productMapper.toEntity(requestDto);
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDto(savedProduct);
    }

    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));

        Category category = categoryRepository.findById(requestDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        existingProduct.setName(requestDto.getName());
        existingProduct.setDescription(requestDto.getDescription());
        existingProduct.setPrice(requestDto.getPrice());
        existingProduct.setStockQuantity(requestDto.getStockQuantity());
        existingProduct.setCategory(category);

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toResponseDto(updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado: " + id);
        }
        productRepository.deleteById(id);
    }

}
