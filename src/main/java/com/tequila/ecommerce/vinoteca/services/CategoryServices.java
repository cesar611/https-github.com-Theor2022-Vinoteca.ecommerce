package com.tequila.ecommerce.vinoteca.services;

import com.tequila.ecommerce.vinoteca.models.Category;
import com.tequila.ecommerce.vinoteca.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository categoriaRepository;

    public List<Category> obtenerTodasLasCategorias(){
        return categoriaRepository.findAll();
    }
    public Category obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Category guardarCategorias(Category categoria) {

        return categoriaRepository.save(categoria);
    }

    public void eliminarCategorias(Long id) {
        categoriaRepository.deleteById(id);
    }

}
