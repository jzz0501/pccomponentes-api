package com.pccomponentes.practice.service.pedido;

import com.pccomponentes.practice.dto.PedidoDTO;
import com.pccomponentes.practice.entity.BasketProduct;
import com.pccomponentes.practice.entity.Client;
import com.pccomponentes.practice.entity.Pedido;
import com.pccomponentes.practice.entity.PedidoDetail;
import com.pccomponentes.practice.mapper.PedidoMapper;
import com.pccomponentes.practice.repository.BasketProductRepo;
import com.pccomponentes.practice.repository.ClientRepo;
import com.pccomponentes.practice.repository.PedidoDetailRepo;
import com.pccomponentes.practice.repository.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements iPedidoService {

    @Autowired
    PedidoRepo pedidoRepo;
    @Autowired
    PedidoDetailRepo pedidoDetailRepo;
    @Autowired
    BasketProductRepo basketProductRepo;
    @Autowired
    ClientRepo clientRepo;

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

    @Override
    public Boolean addPedidoOfClient(Long id_client, Long id_basket) {

        Optional<Client> client = clientRepo.findById(id_client);
        if (client.isEmpty()) return false;
        List<BasketProduct> basketProducts = basketProductRepo.findByBasketID(id_basket);
        if (basketProducts.isEmpty()) return false;

        Pedido pedido = new Pedido();
        pedido.setCreatedDate(LocalDate.now().toString());
        pedido.setClient(client.get());

        Pedido pedidoInserted = pedidoRepo.save(pedido);
        basketProducts.forEach(basketProduct -> {
            PedidoDetail pedidoDetail = new PedidoDetail();
            pedidoDetail.setPedido(pedidoInserted);
            pedidoDetail.setProduct(basketProduct.getProduct());
            pedidoDetail.setQuantity(basketProduct.getQuantity());
            pedidoDetail.setUnitPrice(basketProduct.getProduct().getPrice());
            pedidoDetailRepo.save(pedidoDetail);
            basketProductRepo.delete(basketProduct);
        });

        return true;
    }
}