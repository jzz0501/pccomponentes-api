package com.pccomponentes.practice.service.client;

import com.pccomponentes.practice.dto.ClientDTO;

public interface iClientService {

    ClientDTO findClientByID(Long id_client);

}
