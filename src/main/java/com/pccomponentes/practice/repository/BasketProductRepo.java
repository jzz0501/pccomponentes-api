package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasketProductRepo extends JpaRepository<BasketProduct, Long> {

    @Query("FROM BasketProduct WHERE basket.id = :id_basket")
    List<BasketProduct> findByBasketID(Long id_basket);

}
