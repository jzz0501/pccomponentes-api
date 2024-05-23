package com.pccomponentes.practice.exception;

import com.pccomponentes.practice.util.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ResponseEntity<Result<Object>> exceptionHandler(Exception e) {
        if(e instanceof APIException apiException) {
            return new ResponseEntity<>(new Result<>(apiException.getCode(), apiException.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Result<>(APIRequestException.INTERNAL_SERVER_ERROR.getCode(), APIRequestException.INTERNAL_SERVER_ERROR.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

}