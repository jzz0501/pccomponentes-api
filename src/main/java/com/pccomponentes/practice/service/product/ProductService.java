package com.pccomponentes.practice.service.product;

import com.pccomponentes.practice.dto.ProductDTO;
import com.pccomponentes.practice.dto.ProductDetailDTO;
import com.pccomponentes.practice.entity.Product;
import com.pccomponentes.practice.entity.ProductDetail;
import com.pccomponentes.practice.mapper.ProductDetailMapper;
import com.pccomponentes.practice.mapper.ProductMapper;
import com.pccomponentes.practice.repository.ProductDetailRepo;
import com.pccomponentes.practice.repository.ProductRepo;
import com.pccomponentes.practice.repository.ProductSaleRepo;
import com.pccomponentes.practice.util.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements iProductService{

    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductDetailRepo productDetailRepo;
    @Autowired
    ProductSaleRepo productSaleRepo;

    @Override
    public Pageable<ProductDTO> matchAllProductByName(String productName, Integer page) {
        Page<Product> productPage = productRepo.matchByName(productName, PageRequest.of(page-1, 10));
        List<ProductDTO> productDTOList = new ProductMapper().mapProductListToProductDTOList(productPage.getContent());
        Pageable<ProductDTO> productDTOPageable = new Pageable<>();
        productDTOPageable.setCurrentPage(productPage.getPageable().getPageNumber() + 1);
        productDTOPageable.setTotalPage(productPage.getTotalPages());
        productDTOPageable.setTotalItem(productPage.getTotalElements());
        productDTOPageable.setPrevPageURL("");
        productDTOPageable.setNextPageURL("");
        productDTOPageable.setItems(productDTOList);
        return productDTOPageable;
    }

    @Override
    public Pageable<ProductDTO> findAllProductByCategoryName(String categoryName, Integer page) {
        Page<Product> productPage = productRepo.findByCategoryName(categoryName, PageRequest.of(page-1, 10));
        List<ProductDTO> productDTOList = new ProductMapper().mapProductListToProductDTOList(productPage.getContent());
        Pageable<ProductDTO> productDTOPageable = new Pageable<>();
        productDTOPageable.setCurrentPage(productPage.getPageable().getPageNumber() + 1);
        productDTOPageable.setTotalPage(productPage.getTotalPages());
        productDTOPageable.setTotalItem(productPage.getTotalElements());
        productDTOPageable.setPrevPageURL("");
        productDTOPageable.setNextPageURL("");
        productDTOPageable.setItems(productDTOList);
        return productDTOPageable;
    }

    @Override
    public List<ProductDTO> findBestSellerProductByCategory(String category, Integer quantity) {
        return new ProductMapper().mapProductSaleListToProductDTOList(productSaleRepo.findByCategoryOrderBySoldDesc(category, quantity));
    }

    @Override
    public ProductDetailDTO findProductDetailByName(String productName) {
        ProductDetail productDetail = productDetailRepo.findByName(productName);
        return ProductDetailMapper.mapToProductDetailDTO(productDetail);
    }
}
