package com.pccomponentes.practice.mapper;

import com.pccomponentes.practice.dto.ClientDTO;
import com.pccomponentes.practice.entity.Client;

public class ClientMapper {

    public static ClientDTO mapToClientDTO(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getEmail(),
                client.getFullname(),
                client.getBirthday(),
                client.getBasket()
        );
    }

}
