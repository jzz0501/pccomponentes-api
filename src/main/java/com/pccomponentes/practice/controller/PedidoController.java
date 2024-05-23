package com.pccomponentes.practice.controller;

import com.pccomponentes.practice.dto.PedidoDTO;
import com.pccomponentes.practice.entity.Pedido;
import com.pccomponentes.practice.service.pedido.PedidoService;
import com.pccomponentes.practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/{id_client}")
    public ResponseEntity<Result<List<PedidoDTO>>> getAllPedidoOfClient(@PathVariable("id_client") Long id_client) {
        Result<List<PedidoDTO>> result = new Result<>(1, "success", pedidoService.findAllPedidoOfClient(id_client));
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{id_client}/{id_basket}")
    public ResponseEntity<Result<Boolean>> addPedidoOfClient(@PathVariable("id_client") Long id_client, @PathVariable("id_basket") Long id_basket) {
        Result<Boolean> result = new Result<>(1, "success", pedidoService.addPedidoOfClient(id_client, id_basket));
        return ResponseEntity.ok(result);
    }

}