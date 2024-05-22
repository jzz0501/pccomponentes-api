package com.pccomponentes.practice.dto;

import com.pccomponentes.practice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasketProductDTO {

    private Long id;

    private Product product;

    private Integer quantity;

}
