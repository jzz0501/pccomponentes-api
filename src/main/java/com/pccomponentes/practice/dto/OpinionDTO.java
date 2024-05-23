package com.pccomponentes.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OpinionDTO {

    private Long id;

    private String comment;

    private String createdDate;

    private Integer score;

    private String clientEmail;

}
