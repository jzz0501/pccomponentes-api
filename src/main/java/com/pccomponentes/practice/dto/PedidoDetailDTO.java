package com.pccomponentes.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDetailDTO {

    private BigDecimal unitPrice;

    private Integer quantity;

    private String webURL;

    private String imageURL;

    private String name;

}
