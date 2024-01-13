package com.example.crud.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product/*Recebe a entidade que irá ser manipulada*/, String/*Tipo da Pkey*/> {
    List<Product> findAllByActiveTrue();
} //Interface do Jpa para manipulação de uma entidade em RunTime
