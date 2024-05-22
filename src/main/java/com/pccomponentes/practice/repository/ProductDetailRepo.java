package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDetailRepo extends JpaRepository<ProductDetail, Long> {

    @Query("FROM ProductDetail WHERE product.name LIKE :productName")
    ProductDetail findByName(String productName);

}
