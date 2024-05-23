package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepo extends JpaRepository<Client, Long> {

    @Query("FROM Client WHERE email LIKE :email AND password LIKE :password")
    Client findByEmailAndPassword(String email, String password);

}
