package com.tequila.ecommerce.vinoteca.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//anotaciones de longbok (instalar plugin)
//cambiar a estructura DTO

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación ManyToOne con el carrito (Cart)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Relación ManyToOne con el producto (Product)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<Product> products;

    // Cantidad del producto en el carrito
    private int quantity;



}
