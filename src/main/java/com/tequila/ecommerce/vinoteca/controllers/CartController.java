package com.tequila.ecommerce.vinoteca.controllers;

import com.tequila.ecommerce.vinoteca.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/api/carrito")
public class CartController {

  @Autowired
  private com.tequila.ecommerce.vinoteca.services.CartService CartService;

  @PostMapping
  public ResponseEntity<Cart> crearCarrito(@RequestBody Cart carrito) {
    Cart nuevoCarrito = CartService.CrearCart(carrito);
    return ResponseEntity.ok(nuevoCarrito);
  }

  @PutMapping
  public ResponseEntity<Object> modificarCarrito(@RequestBody Cart carrito) {
    Cart carritoModificado = CartService.modificarCart(carrito);
    return ResponseEntity.ok(carritoModificado);
  }
  @PutMapping
      public ResponseEntity<Object> agregarProducto(@RequestBody Cart carrito) {
    Cart carritoModificado = CartService.agregarProducto(carrito);
    return ResponseEntity.ok(carritoModificado);
  }
}

