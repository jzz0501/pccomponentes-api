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

    @PutMapping("/{id_basket}/{id_product}/{quantity}")
    public ResponseEntity<Result<Boolean>> insertProductToBasket(@PathVariable("id_basket") Long id_basket,
                                                                 @PathVariable("id_product") Long id_product,
                                                                 @PathVariable("quantity") Integer quantity) {
        Result<Boolean> result = new Result<>(1, "success", basketService.updateProductOfBasket(id_basket, id_product, quantity));
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id_basketProduct}")
    public ResponseEntity<Result<Boolean>> deleteProductOfBasket(@PathVariable("id_basketProduct") Long id_basketProduct) {
        Result<Boolean> result = new Result<>(1, "success", basketService.deleteProductOfBasket(id_basketProduct));
        return ResponseEntity.ok(result);
    }
}
