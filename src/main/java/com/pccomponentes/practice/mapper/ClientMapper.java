package com.pccomponentes.practice.mapper;

import com.pccomponentes.practice.dto.ClientDTO;
import com.pccomponentes.practice.entity.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ClientMapper {

    ModelMapper modelMapper = new ModelMapper();

    public ClientDTO mapToClientDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

}
