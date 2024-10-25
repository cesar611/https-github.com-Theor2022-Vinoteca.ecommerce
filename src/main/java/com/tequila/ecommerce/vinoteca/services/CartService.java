package com.tequila.ecommerce.vinoteca.services;

import com.tequila.ecommerce.vinoteca.models.Cart;
import com.tequila.ecommerce.vinoteca.models.Product;
import com.tequila.ecommerce.vinoteca.models.ProductCart;
import com.tequila.ecommerce.vinoteca.models.User;
import com.tequila.ecommerce.vinoteca.repository.CartRepository;
import com.tequila.ecommerce.vinoteca.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public Cart crearCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
        return cart;
    }

    public Cart modificarCart(Cart cart) {
        return cart;

    }
    public Cart modificarProducto(User user, Long productId, int quantityDelta) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));

        Cart cart = cartRepository.findByUser(user).orElse(null);

        if (cart == null) {
            cart = crearCart(user);
        }

        boolean isProductInCart = false;
        for (ProductCart item : cart.getProducts()) {
            for (Product productInCart : item.getProducts()) {
                if (productInCart.getId().equals(productId)) {
                    int currentQuantity = item.getQuantity();
                    int newQuantity = currentQuantity + quantityDelta;
                    if (newQuantity < 1) {
                        cart.getProducts().remove(item);
                    } else {
                        item.setQuantity(newQuantity);
                    }
                    isProductInCart = true;
                    break;
                }
            }
            if (isProductInCart) {
                break;
            }
        }

        if (!isProductInCart) {
            ProductCart newCartItem = new ProductCart();
            newCartItem.setProducts(List.of(product));
            newCartItem.setQuantity(quantityDelta);
            cart.getProducts().add(newCartItem);
        }

        cartRepository.save(cart);
        return cart;
    }

    public void emptyCart(Cart cart) {
        cart.getProducts().clear();
        cartRepository.save(cart);
    }

    public List<ProductCart> getProducts(Cart cart) {
        return cartRepository.findByUser(cart.getUser()).orElseThrow(() -> new IllegalArgumentException("Cart not found with user: " + cart.getUser())).getProducts();
    }



}