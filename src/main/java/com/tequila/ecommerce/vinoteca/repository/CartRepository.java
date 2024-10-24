package com.tequila.ecommerce.vinoteca.repository;

import com.tequila.ecommerce.vinoteca.models.Cart;
import com.tequila.ecommerce.vinoteca.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}