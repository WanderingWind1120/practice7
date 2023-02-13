package com.example.practice7.repositories;

import com.example.practice7.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByProductName (String productName);

    @Override
    List<Product> findAll();
    Optional<Product> findById (Long id);
}
