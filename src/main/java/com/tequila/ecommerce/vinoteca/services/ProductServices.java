package com.tequila.ecommerce.vinoteca.services;

import com.tequila.ecommerce.vinoteca.models.Product;
import com.tequila.ecommerce.vinoteca.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productoRepository;



    public List<Product> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Product obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Product guardarProducto(Product producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
