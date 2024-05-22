package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepo extends JpaRepository<Basket, Long> {
}
