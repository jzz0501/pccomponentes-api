package com.pccomponentes.practice.service.auth;

import com.pccomponentes.practice.dto.ClientDTO;

public interface iAuthService {

    String login(String email, String password);

    ClientDTO validateToken(String token);

}
