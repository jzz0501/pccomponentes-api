package com.pccomponentes.practice.service.client;

import com.pccomponentes.practice.dto.ClientDTO;
import com.pccomponentes.practice.entity.Client;
import com.pccomponentes.practice.mapper.ClientMapper;
import com.pccomponentes.practice.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements iClientService{

    @Autowired
    ClientRepo clientRepo;

    @Override
    public ClientDTO findClientByID(Long id_client) {
        Optional<Client> client = clientRepo.findById(id_client);
        return client.map(new ClientMapper()::mapToClientDTO).orElse(null);
    }
}
