package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("FROM Product WHERE name LIKE %:productName%")
    Page<Product> matchByName(String productName, Pageable pageable);

}
