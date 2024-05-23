package com.pccomponentes.practice.controller;

import com.pccomponentes.practice.dto.ClientDTO;
import com.pccomponentes.practice.dto.OpinionDTO;
import com.pccomponentes.practice.service.opinion.OpinionService;
import com.pccomponentes.practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
