package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepo extends JpaRepository<Opinion, Long> {
}
