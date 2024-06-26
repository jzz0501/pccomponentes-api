package com.pccomponentes.practice.service.basket;

import com.pccomponentes.practice.dto.BasketProductDTO;

import java.util.List;

public interface iBasketService {

    List<BasketProductDTO> findAllProductOfBasket(Long id_basket);

    Boolean updateProductOfBasket(Long id_basket, Long id_product, Integer quantity);

    Boolean deleteProductOfBasket(Long id_basketProduct);

}