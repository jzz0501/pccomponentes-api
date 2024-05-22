package com.pccomponentes.practice.controller;

import com.pccomponentes.practice.service.category.CategoryService;
import com.pccomponentes.practice.service.product.ProductService;
import com.pccomponentes.practice.util.Result;
import com.pccomponentes.practice.util.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/page")
public class PageController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public ResponseEntity<Result<ArrayList<Section>>> getHomeData() {

        ArrayList<Section> sections = new ArrayList<>();

        Section categorySection = new Section();
        categorySection.setTitle("Categories");
        categorySection.setTemplate("display:template:module");
        categorySection.setItems(categoryService.findAllCategoryAction());

        Section bestSelledCPUSection = new Section();
        bestSelledCPUSection.setTitle("CPU Mas vendido");
        bestSelledCPUSection.setTemplate("display:template:railcarousel");
        bestSelledCPUSection.setItems(productService.findBestSellerProductByCategory("CPU", 10));

        sections.add(categorySection);
        sections.add(bestSelledCPUSection);

        Result<ArrayList<Section>> result = new Result<>(1, "success", sections);
        return ResponseEntity.ok(result);

    }
}