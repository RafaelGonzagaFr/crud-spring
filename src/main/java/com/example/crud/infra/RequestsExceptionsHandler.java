package com.example.crud.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //Toda vez que for lidar com uma exceção essa classe será chamada
public class RequestsExceptionsHandler {
    @ExceptionHandler(EntityNotFoundException.class) //O que essa exceção está tratando
    public ResponseEntity threat404(){
        return ResponseEntity.badRequest().body("Dado não encontrado");
    }
}
