package com.tequila.ecommerce.vinoteca.controllers;


import com.tequila.ecommerce.vinoteca.models.User;
import com.tequila.ecommerce.vinoteca.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {


    @Autowired
    private UserService userService;

    // GET /usuario
    @GetMapping
    public ResponseEntity<List<User>> obtenerTodosLosUsuarios(){
        List<User> users = userService.obtenerTodosLosUsuarios();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    // GET /usuario/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> obtenerUsuariosPorId(@PathVariable Long id){
        User user = userService.obtenerUsuarioPorId(id);
        if(user!=null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST /usuario
    @PostMapping
    public ResponseEntity<User> guardarUsuario(@RequestBody User user){
        User nuevoUsuario = userService.guardarUsuario(user);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // DELETE /usuario/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        userService.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
