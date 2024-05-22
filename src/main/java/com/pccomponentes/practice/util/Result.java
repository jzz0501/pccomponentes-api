package com.pccomponentes.practice.util;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

}
