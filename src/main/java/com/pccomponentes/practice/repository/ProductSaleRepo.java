package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductSaleRepo extends JpaRepository<ProductSale, Long> {

    @Query("FROM ProductSale WHERE product.category.name LIKE :category ORDER BY sold DESC LIMIT :quantity")
    List<ProductSale> findByCategoryOrderBySoldDesc(String category, Integer quantity);

}
