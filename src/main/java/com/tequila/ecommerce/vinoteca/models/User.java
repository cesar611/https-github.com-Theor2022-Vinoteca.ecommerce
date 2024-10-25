package com.tequila.ecommerce.vinoteca.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")//name de la tabla en la  base de datos

public class User {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El valor de este campo se generará automáticamente
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre") // nombre de la columna en la base de datos
    private String name;
    @Column(name = "email") // nombre de la columna en la base de datos
    private String email;
    @Column(name = "password") // nombre de la columna en la base de datos
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "isAdmin")
    private Boolean isAdmin;


    @OneToMany(mappedBy = "user") // Define una relación de uno a muchos con la entidad Order
    private List<Order> orders;

    public Long id() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String nombre() {
        return name;
    }

    public User setNombre(String nombre) {
        this.name = nombre;
        return this;
    }

    public String email() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String phone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public User setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    public String password() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Order> pedidos() {
        return orders;
    }

    public User setPedidos(List<Order> orders) {
        this.orders = orders;
        return this;
    }
}