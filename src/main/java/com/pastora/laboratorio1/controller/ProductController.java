package com.pastora.laboratorio1.controller;

import com.pastora.laboratorio1.dto.ProductRequestDto;
import com.pastora.laboratorio1.dto.ProductResponseDto;
import com.pastora.laboratorio1.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER-ADMIN-ROLE')")
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto requestDto) {
        return new ResponseEntity<>(productService.createProduct(requestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER-ADMIN-ROLE')")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDto requestDto) {
        return ResponseEntity.ok(productService.updateProduct(id, requestDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER-ADMIN-ROLE')")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
