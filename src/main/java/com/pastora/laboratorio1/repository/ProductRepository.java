package com.pastora.laboratorio1.repository;

import com.pastora.laboratorio1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
}
