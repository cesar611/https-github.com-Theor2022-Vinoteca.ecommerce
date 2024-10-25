package com.tequila.ecommerce.vinoteca.controllers;

import com.tequila.ecommerce.vinoteca.models.Cart;
import com.tequila.ecommerce.vinoteca.models.Order;
import com.tequila.ecommerce.vinoteca.models.ProductCart;
import com.tequila.ecommerce.vinoteca.models.User;
import com.tequila.ecommerce.vinoteca.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/carrito")
public class CartController {

  @Autowired
  private com.tequila.ecommerce.vinoteca.services.CartService CartService;

  @Autowired
  private OrderRepository OrderRepository;

  @PostMapping
  public ResponseEntity<Cart> crearCarrito(@RequestBody Cart carrito) {
    Cart nuevoCarrito = CartService.crearCart(carrito.getUser());
    return ResponseEntity.ok(nuevoCarrito);
  }

  @PutMapping("/modificarProducto")
  public ResponseEntity<Object> modificarProducto(@RequestBody Cart carrito, long productId, int quantityDelta) {
      Cart carritoModificado = CartService.modificarProducto(carrito.getUser(), productId, quantityDelta);
      return ResponseEntity.ok(carritoModificado);
  }

  @DeleteMapping("/emptyCart")
  public ResponseEntity<Void> emptyCart(@RequestBody Cart cart) {
      CartService.emptyCart(cart);return ResponseEntity.noContent().build();
  }

  @GetMapping("/getCart")
  public ResponseEntity<List<ProductCart>> getCart(@RequestBody Cart cart) {
      List<ProductCart> products = CartService.getProducts(cart);
      return ResponseEntity.ok(products);
  }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestBody Cart cart, @RequestParam String direccion, @RequestParam User user) {
        List<ProductCart> products = CartService.getProducts(cart);
        Order order = new Order();
        order.setProductCarts(products);
        order.setDireccion(direccion);
        order.setUser(user);
        order = OrderRepository.save(order);
        return ResponseEntity.ok(order);
    }
}

