package com.tequila.ecommerce.vinoteca.services;

import com.tequila.ecommerce.vinoteca.models.Cart;
import com.tequila.ecommerce.vinoteca.models.Product;
import com.tequila.ecommerce.vinoteca.models.ProductCart;
import com.tequila.ecommerce.vinoteca.models.User;
import com.tequila.ecommerce.vinoteca.repository.CartRepository;
import com.tequila.ecommerce.vinoteca.repository.ProductRepository;


public class CartService {
    public Cart CrearCart(User user) {

        Cart carrito = new Cart();
        carrito.setUser(user);
        CartRepository.save(carrito);

        return carrito;
    }

    public Cart modificarCart(Cart carrito) {

        return carrito;
    }


    public Cart agregarProducto(User user, Long productId, int quantity) {
        // 1. Find the product in the repository
        Product product = ProductRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // 2. Find the cart of the user
        Cart cart = CartRepository.findByUser(user).orElse(null);

        // If the cart does not exist, create a new cart for the user
        if (cart == null) {
            cart = CrearCart(user);
            CartRepository.save(cart);
        }

        // 3. Check if the product is already in the cart
        ProductCart existingCartItem = cart.getProducts().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (existingCartItem != null) {
            // 4. If the product is already in the cart, increment the quantity
            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
        } else {
            // 5. If the product is not in the cart, add it as a new CartItem
            ProductCart newCartItem = new ProductCart();
            newCartItem.setProduct(product);
            newCartItem.setQuantity(quantity);
            cart.getProducts().add(newCartItem);
        }

        // 6. Save the updated cart in the database
        CartRepository.save(cart);
        return cart;
    }
}
