package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepo extends JpaRepository<Pedido, Long> {

    @Query("FROM Pedido WHERE client.id = :id_client")
    List<Pedido> findByClientID(Long id_client);

}
