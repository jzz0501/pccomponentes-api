package com.pccomponentes.practice.controller;

import com.pccomponentes.practice.dto.BasketProductDTO;
import com.pccomponentes.practice.service.basket.BasketService;
import com.pccomponentes.practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/basket")
public class BasketController {

    @Autowired
    BasketService basketService;

    @GetMapping("/{id_basket}")
    public ResponseEntity<Result<List<BasketProductDTO>>> getAllProductOfBasket(@PathVariable("id_basket") Long id_basket) {
        Result<List<BasketProductDTO>> result = new Result<>(1, "success", basketService.findAllProductOfBasket(id_basket));
        return ResponseEntity.ok(result);
    }

}
