package com.tequila.ecommerce.vinoteca.models;

import jakarta.persistence.*;

import java.util.List;

//anotaciones de longbok (instalar plugin)
//cambiar a estructura DTO

@Entity
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación ManyToOne con el carrito (Cart)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Relación ManyToMany con el producto (Product)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<Product> products;

    // Cantidad del producto en el carrito
    private int quantity;

    public ProductCart(Long id, Cart cart, List<Product> products, int quantity) {
        this.id = id;
        this.cart = cart;
        this.products = products;
        this.quantity = quantity;
    }

    public ProductCart() {
    }


    // Getters y Setters

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return this.id;
    }

    public Cart getCart() {
        return this.cart;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
