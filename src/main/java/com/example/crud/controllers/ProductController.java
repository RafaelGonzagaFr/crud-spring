package com.example.crud.controllers;

import com.example.crud.domain.product.Product;
import com.example.crud.domain.product.ProductRepository;
import com.example.crud.domain.product.RequestProduct;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.Optional;

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
    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data){ //Método responsável por atualizar
        Optional<Product> optionalProduct = repository.findById(data.id());
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
