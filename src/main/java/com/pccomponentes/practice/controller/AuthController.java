package com.pccomponentes.practice.controller;

import com.pccomponentes.practice.dto.ClientDTO;
import com.pccomponentes.practice.entity.Client;
import com.pccomponentes.practice.service.auth.AuthService;
import com.pccomponentes.practice.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Result<String>> login(@RequestBody HashMap<String, String> signin) {
        String token = authService.login(signin.get("email"), signin.get("password"));
        return ResponseEntity.ok(token == null? new Result<>(-1, "verification failed", null) : new Result<>(1, "success", token));
    }

    @PostMapping("/validate")
    public ResponseEntity<ClientDTO> validateToken(HttpServletRequest request) {
        ClientDTO clientDTO = authService.validateToken(request.getHeader("token"));
        return ResponseEntity.ok(clientDTO);
    }

}