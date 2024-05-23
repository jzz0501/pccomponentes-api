package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpinionRepo extends JpaRepository<Opinion, Long> {

    @Query("FROM Opinion WHERE product.id = :id_product")
    List<Opinion> findByProductID(Long id_product);

}
