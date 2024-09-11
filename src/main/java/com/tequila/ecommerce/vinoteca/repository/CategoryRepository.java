package com.tequila.ecommerce.vinoteca.repository;

import com.tequila.ecommerce.vinoteca.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByTipoBebida(String tipoBebida);
    List<Category> findByTipoProducto(String tipoProducto);
}