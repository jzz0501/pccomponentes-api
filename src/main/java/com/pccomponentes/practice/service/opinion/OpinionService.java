package com.pccomponentes.practice.service.opinion;

import com.pccomponentes.practice.dto.OpinionDTO;
import com.pccomponentes.practice.entity.Opinion;
import com.pccomponentes.practice.mapper.OpinionMapper;
import com.pccomponentes.practice.repository.OpinionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService implements iOpinionService{

    @Autowired
    OpinionRepo opinionRepo;

    @Override
    public List<OpinionDTO> findAllOpinionOfProduct(Long id_product) {
        List<Opinion> opinionDTOS = opinionRepo.findByProductID(id_product);
        return OpinionMapper.mapToOpinionDTOList(opinionDTOS);
    }
}
