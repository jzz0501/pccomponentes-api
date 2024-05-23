package com.pccomponentes.practice.mapper;

import com.pccomponentes.practice.dto.OpinionDTO;
import com.pccomponentes.practice.entity.Opinion;

import java.util.List;
import java.util.stream.Collectors;

public class OpinionMapper {

    public static List<OpinionDTO> mapToOpinionDTOList(List<Opinion> opinionList) {
        return opinionList
                .stream()
                .map(opinion -> new OpinionDTO(
                        opinion.getId(),
                        opinion.getComment(),
                        opinion.getCreatedDate(),
                        opinion.getScore(),
                        opinion.getClient().getEmail()
                ))
                .collect(Collectors.toList());
    }

}
