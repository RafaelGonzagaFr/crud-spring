package com.example.crud.controllers;

import com.example.crud.domain.product.Product;
import com.example.crud.domain.product.ProductRepository;
import com.example.crud.domain.product.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

@RestController //Indicar que essa classe representa um controller
@RequestMapping("/product") //Definir o caminho desse controller
public class ProductController {
    @Autowired //O que tem que ser injetado
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity getAllProducts(){ //Response para o request /product
        var allProducts = repository.findAll(); //Vai pegar todos os dados da tabela
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data /*Pegar o corpo do post para inserir dados*/){
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }
    @PutMapping()
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data){ //Método responsável por atualizar
        Product product = repository.getReferenceById(data.id());// Atualizando por ID
        product.setName(data.name());
        product.setPrice_in_cents(data.price_in_cents());
        return ResponseEntity.ok(product);
    }
}
