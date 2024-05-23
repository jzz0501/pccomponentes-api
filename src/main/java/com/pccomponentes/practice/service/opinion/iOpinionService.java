package com.pccomponentes.practice.service.opinion;

import com.pccomponentes.practice.dto.OpinionDTO;

import java.util.List;
import java.util.Map;

public interface iOpinionService {

    List<OpinionDTO> findAllOpinionOfProduct(Long id_product);

    Boolean addOpinionOfProduct(Long id_product, Long id_client, Map<String, String> comments);

    Boolean removeOpinionOfProduct(Long id_opinion);

}