package com.pccomponentes.practice.controller;

import com.pccomponentes.practice.dto.ProductDTO;
import com.pccomponentes.practice.dto.ProductDetailDTO;
import com.pccomponentes.practice.service.product.ProductService;
import com.pccomponentes.practice.util.Pageable;
import com.pccomponentes.practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/match-name/{product_name}")
    public ResponseEntity<Result<Pageable<ProductDTO>>> getProductByName(@PathVariable("product_name") String productName,
                                                                         @RequestParam(value = "pageNO", required = false, defaultValue = "1") Integer pageNO) {
        Result<Pageable<ProductDTO>> productDTOListResult = new Result<>(1,"success",productService.matchAllProductByName(productName, pageNO));
        return ResponseEntity.ok(productDTOListResult);
    }

    @GetMapping("/detail/{product_name}")
    public ResponseEntity<Result<ProductDetailDTO>> getProductDetailByName(@PathVariable("product_name") String productName) {
        Result<ProductDetailDTO> productDTOResult = new Result<>(1,"success",productService.findProductDetailByName(productName));
        return ResponseEntity.ok(productDTOResult);
    }

}
