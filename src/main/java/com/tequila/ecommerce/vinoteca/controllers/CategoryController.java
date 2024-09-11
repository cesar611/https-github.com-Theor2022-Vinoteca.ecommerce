package com.tequila.ecommerce.vinoteca.controllers;

import com.tequila.ecommerce.vinoteca.models.Category;
import com.tequila.ecommerce.vinoteca.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public ResponseEntity<List<Category>> obtenerTodasLasCategorias() {
        List<Category> categorias = categoryServices.obtenerTodasLasCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> obtenerCategoriaPorId(@PathVariable Long id) {
        Category categoria = categoryServices.obtenerCategoriaPorId(id);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Category> guardarCategoria(@RequestBody Category categoria) {
        Category nuevaCategoria = categoryServices.guardarCategorias(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        categoryServices.eliminarCategorias(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
