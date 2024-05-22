package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
