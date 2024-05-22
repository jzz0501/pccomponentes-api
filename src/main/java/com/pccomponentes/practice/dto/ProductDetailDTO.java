package com.pccomponentes.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDetailDTO {

    private Long id;

    private String slug;

    private String name;

    private BigDecimal price;

    private BigDecimal lowestPrice;

    private String webURL;

    private String imageURL;

    private BigDecimal discount;

    private HashMap<String, String> contextData;

}
