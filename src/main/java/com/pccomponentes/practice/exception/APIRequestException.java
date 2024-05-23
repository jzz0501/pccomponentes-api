package com.pccomponentes.practice.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum APIRequestException {

    INTERNAL_SERVER_ERROR(0, "Internal server error"),
    NOT_LOGIN(-1, "Not logged in"),
    LOGIN_FAILED(-2, "Login failed"),
    INVALIDATE_TOKEN(-3, "Invalidate token expected"),
    OUT_OF_STOCK(-4, "Product is out of stock");

    private Integer code;

    private String message;

}