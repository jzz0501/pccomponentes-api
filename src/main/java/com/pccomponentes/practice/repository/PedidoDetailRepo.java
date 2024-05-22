package com.pccomponentes.practice.repository;

import com.pccomponentes.practice.entity.PedidoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoDetailRepo extends JpaRepository<PedidoDetail, Long> {

    @Query("FROM PedidoDetail WHERE pedido.id = :id_pedido")
    List<PedidoDetail> findByPedidoID(Long id_pedido);

}