package com.pccomponentes.practice.service.pedido;

import com.pccomponentes.practice.dto.PedidoDTO;
import com.pccomponentes.practice.dto.PedidoDetailDTO;
import com.pccomponentes.practice.entity.Pedido;
import com.pccomponentes.practice.entity.PedidoDetail;
import com.pccomponentes.practice.mapper.PedidoMapper;
import com.pccomponentes.practice.repository.PedidoDetailRepo;
import com.pccomponentes.practice.repository.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService implements iPedidoService {

    @Autowired
    PedidoRepo pedidoRepo;
    @Autowired
    PedidoDetailRepo pedidoDetailRepo;

    @Override
    public List<PedidoDTO> findAllPedidoOfClient(Long id_client) {

        List<PedidoDTO> pedidoDTOList = new ArrayList<>();

        List<Pedido> pedidos = pedidoRepo.findByClientID(id_client);
        pedidos.forEach(pedido -> {
            List<PedidoDetail> pedidoDetails = pedidoDetailRepo.findByPedidoID(pedido.getId());
            PedidoDTO pedidoDTO = PedidoMapper.mapToPedidoDTO(pedido, PedidoMapper.mapToPedidoDetailDTO(pedidoDetails));
            pedidoDTOList.add(pedidoDTO);
        });

        return pedidoDTOList;
    }
}