package com.pccomponentes.practice.service.pedido;

import com.pccomponentes.practice.dto.PedidoDTO;
import com.pccomponentes.practice.entity.Pedido;

import java.util.List;

public interface iPedidoService {

    List<PedidoDTO> findAllPedidoOfClient(Long id_client);

    Boolean addPedidoOfClient(Long id_client, Long id_basket);

}