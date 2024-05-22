package com.pccomponentes.practice.controller;

import com.pccomponentes.practice.dto.ClientDTO;
import com.pccomponentes.practice.service.client.ClientService;
import com.pccomponentes.practice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id_client}")
    public ResponseEntity<Result<ClientDTO>> getClientFullData(@PathVariable("id_client") Long id_client) {
        Result<ClientDTO> clientDTOResult = new Result<>(1,"success",clientService.findClientByID(id_client));
        return ResponseEntity.ok(clientDTOResult);
    }

}
