package com.pccomponentes.practice.service.auth;

import com.pccomponentes.practice.dto.ClientDTO;
import com.pccomponentes.practice.entity.Client;
import com.pccomponentes.practice.exception.APIException;
import com.pccomponentes.practice.exception.APIRequestException;
import com.pccomponentes.practice.mapper.ClientMapper;
import com.pccomponentes.practice.repository.ClientRepo;
import com.pccomponentes.practice.util.JWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService implements iAuthService {

    @Autowired
    ClientRepo clientRepo;

    @Override
    public String login(String email, String password) {
        Client client = clientRepo.findByEmailAndPassword(email, password);
        if(client == null) throw new APIException(APIRequestException.LOGIN_FAILED);
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", client.getEmail());
        claims.put("password", client.getPassword());
        return JWT.generateJwt(claims);
    }

    @Override
    public ClientDTO validateToken(String token) {

        String username;
        String password;

        try {
            Claims claims = JWT.parseJwt(token);
            username = (String) claims.get("email");
            password = (String) claims.get("password");
        } catch (SignatureException e) {
            return null;
        }

        return ClientMapper.mapToClientDTO(clientRepo.findByEmailAndPassword(username, password));
    }
}
