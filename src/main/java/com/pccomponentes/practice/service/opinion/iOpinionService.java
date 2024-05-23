package com.pccomponentes.practice.service.opinion;

import com.pccomponentes.practice.dto.OpinionDTO;

import java.util.List;

public interface iOpinionService {

    List<OpinionDTO> findAllOpinionOfProduct(Long id_product);

}
