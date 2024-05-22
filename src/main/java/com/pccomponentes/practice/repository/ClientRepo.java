package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
