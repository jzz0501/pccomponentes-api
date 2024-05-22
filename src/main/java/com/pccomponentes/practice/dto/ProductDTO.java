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
public class ProductDTO {

    private Long id;

    private String slug;

    private String name;

    private BigDecimal price;

    private BigDecimal lowestPrice;

    private String webURL;

    private String imageURL;

    private BigDecimal discount;

}
