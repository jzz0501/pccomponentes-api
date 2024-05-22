package com.pccomponentes.practice.mapper;

import com.pccomponentes.practice.dto.PedidoDTO;
import com.pccomponentes.practice.dto.PedidoDetailDTO;
import com.pccomponentes.practice.entity.Pedido;
import com.pccomponentes.practice.entity.PedidoDetail;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    ModelMapper modelMapper = new ModelMapper();

    public static PedidoDTO mapToPedidoDTO(Pedido pedido, List<PedidoDetailDTO> pedidoDetailDTOS) {
        return new PedidoDTO(
                pedido.getId(),
                pedido.getCreatedDate(),
                pedidoDetailDTOS
        );
    }

    public static List<PedidoDetailDTO> mapToPedidoDetailDTO(List<PedidoDetail> pedidoDetails) {
        return pedidoDetails
                .stream()
                .map(pedidoDetail ->
                    new PedidoDetailDTO(
                        pedidoDetail.getUnitPrice(),
                        pedidoDetail.getQuantity(),
                        pedidoDetail.getProduct().getWebURL(),
                        pedidoDetail.getProduct().getImageURL(),
                        pedidoDetail.getProduct().getName()
                ))
                .collect(Collectors.toList());

    }

}
