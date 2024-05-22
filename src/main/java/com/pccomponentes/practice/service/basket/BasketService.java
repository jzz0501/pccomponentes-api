package com.pccomponentes.practice.service.basket;

import com.pccomponentes.practice.dto.BasketProductDTO;
import com.pccomponentes.practice.mapper.BasketProductMapper;
import com.pccomponentes.practice.repository.BasketProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService implements iBasketService {

    @Autowired
    BasketProductRepo basketProductRepo;

    @Override
    public List<BasketProductDTO> findAllProductOfBasket(Long id_basket) {
        return BasketProductMapper.mapToBasketProductDTOList(basketProductRepo.findByBasketID(id_basket));
    }
}
