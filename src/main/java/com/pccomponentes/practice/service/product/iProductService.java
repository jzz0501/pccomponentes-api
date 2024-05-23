package com.pccomponentes.practice.service.product;

import com.pccomponentes.practice.dto.ProductDTO;
import com.pccomponentes.practice.dto.ProductDetailDTO;
import com.pccomponentes.practice.util.Pageable;

import java.util.List;

public interface iProductService {

    Pageable<ProductDTO> matchAllProductByName(String productName, Integer page);

    Pageable<ProductDTO> findAllProductByCategoryName(String categoryName, Integer page);

    List<ProductDTO> findBestSellerProductByCategory(String category, Integer quantity);

    ProductDetailDTO findProductDetailByName(String productName);

}