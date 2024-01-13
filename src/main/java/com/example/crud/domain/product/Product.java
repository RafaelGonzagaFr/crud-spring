package com.example.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name="product") //Nome da tabela que está sendo manipulada
@Entity(name="product") //Entidade que está sendo criada para representar tabela
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id") //Primary key que será usada para identificar ROW
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID) //Forma que é gerada os IDs
    private String id;

    private String name;

    private Integer price_in_cents;

    private Boolean active;

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
        this.active = true;
    }
}
