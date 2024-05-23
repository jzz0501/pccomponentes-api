package com.pccomponentes.practice.controller;

import com.pccomponentes.practice.dto.ClientDTO;
import com.pccomponentes.practice.dto.OpinionDTO;
import com.pccomponentes.practice.service.opinion.OpinionService;
import com.pccomponentes.practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/opinion")
public class OpinionController {

    @Autowired
    OpinionService opinionService;

    @GetMapping("/{id_product}")
    public ResponseEntity<Result<List<OpinionDTO>>> getAllOpinionOfProduct(@PathVariable("id_product") Long id_product) {
        Result<List<OpinionDTO>> clientDTOResult = new Result<>(1,"success",opinionService.findAllOpinionOfProduct(id_product));
        return ResponseEntity.ok(clientDTOResult);
    }

    @PostMapping("/{id_product}/{id_client}")
    public ResponseEntity<Result<Boolean>> addOpinionOfProduct(@PathVariable("id_product") Long id_product,
                                                               @PathVariable("id_client") Long id_client,
                                                               @RequestBody Map<String, String> comments) {
        Result<Boolean> result = new Result<>(1, "success", opinionService.addOpinionOfProduct(id_product, id_client, comments));
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id_opinion}")
    public ResponseEntity<Result<Boolean>> removeOpinionOfProduct(@PathVariable("id_opinion") Long id_opinion) {
        Result<Boolean> result = new Result<>(1, "success", opinionService.removeOpinionOfProduct(id_opinion));
        return ResponseEntity.ok(result);
    }

}
