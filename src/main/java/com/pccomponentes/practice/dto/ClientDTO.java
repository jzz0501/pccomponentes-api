package com.pccomponentes.practice.dto;

import com.pccomponentes.practice.entity.Basket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDTO {

    private Long id;

    private String email;

    private String fullname;

    private String birthday;

    private Basket basket;

}
