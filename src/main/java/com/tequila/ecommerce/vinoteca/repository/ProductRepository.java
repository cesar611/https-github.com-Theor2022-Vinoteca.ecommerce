package com.tequila.ecommerce.vinoteca.repository;

import com.tequila.ecommerce.vinoteca.models.Category;
import com.tequila.ecommerce.vinoteca.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTipoBebida(String tipoBebida);

}
