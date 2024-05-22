package com.pccomponentes.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryActionDTO {

    private Long id;

    private String name;

    private String slug;

    private String description;

    private Map<String, String> actions;

}
