package com.JDBC.App.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice (basePackages = "com.JDBC.App.rest")
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler (value = {RestPokemonException.class})
    public ResponseEntity<Object> handlerRestPokemon (Exception e, WebRequest webRequest){
        String errorText = "Couldn't Add New Pokemon";
        return handleExceptionInternal (e, errorText, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);

    }

}
