package com.pccomponentes.practice.mapper;

import com.pccomponentes.practice.dto.ProductDetailDTO;
import com.pccomponentes.practice.entity.ProductDetail;

import java.util.HashMap;

public class ProductDetailMapper {

    public static ProductDetailDTO mapToProductDetailDTO(ProductDetail productDetail) {

        HashMap<String, String> contextData = new HashMap<>();
        contextData.put("brand", productDetail.getBrand());
        contextData.put("model", productDetail.getModel());
        contextData.put("specifications", productDetail.getSpecifications());
        contextData.put("about", productDetail.getAbout());
        contextData.put("characteristics", productDetail.getCharacteristics());

        return new ProductDetailDTO(
            productDetail.getProduct().getId(),
            productDetail.getProduct().getSlug(),
            productDetail.getProduct().getName(),
            productDetail.getProduct().getPrice(),
            productDetail.getProduct().getLowestPrice(),
            productDetail.getProduct().getWebURL(),
            productDetail.getProduct().getImageURL(),
            productDetail.getProduct().getDiscount(),
            contextData
        );
    }

}
