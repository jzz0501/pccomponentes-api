package com.pccomponentes.practice.mapper;

import com.pccomponentes.practice.dto.ProductDTO;
import com.pccomponentes.practice.entity.Product;
import com.pccomponentes.practice.entity.ProductSale;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    ModelMapper modelMapper = new ModelMapper();

    public List<ProductDTO> mapProductListToProductDTOList(List<Product> products) {
        return products
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> mapProductSaleListToProductDTOList(List<ProductSale> productSales) {
        return productSales
                .stream()
                .map(productSale -> modelMapper.map(productSale.getProduct(), ProductDTO.class))
                .collect(Collectors.toList());
    }

}
