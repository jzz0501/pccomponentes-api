package com.pccomponentes.practice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class APIException extends RuntimeException {

    private Integer code;

    private String message;

    public APIException(APIRequestException apiRequestException) {
        super();
        this.code = apiRequestException.getCode();
        this.message = apiRequestException.getMessage();
    }

}
