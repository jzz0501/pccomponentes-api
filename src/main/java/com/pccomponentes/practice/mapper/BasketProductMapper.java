package com.pccomponentes.practice.mapper;

import com.pccomponentes.practice.dto.BasketProductDTO;
import com.pccomponentes.practice.entity.BasketProduct;

import java.util.List;
import java.util.stream.Collectors;

public class BasketProductMapper {

    public static List<BasketProductDTO> mapToBasketProductDTOList(List<BasketProduct> basketProducts) {
        return basketProducts
                .stream()
                .map(basketProduct ->
                        new BasketProductDTO(
                                basketProduct.getId(),
                                basketProduct.getProduct(),
                                basketProduct.getQuantity()
                        ))
                .collect(Collectors.toList());
    }

}
