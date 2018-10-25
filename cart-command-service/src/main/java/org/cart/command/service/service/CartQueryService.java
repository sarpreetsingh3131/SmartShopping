package org.cart.command.service.service;

import org.cart.domain.service.model.Cart;
import org.cart.domain.service.repository.CartRepository;

import java.util.List;
import java.util.Optional;

public class CartQueryService {

    private CartRepository cartRepository;

    public CartQueryService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> findAll() {
        return this.cartRepository.findAll();
    }

    public Cart findById(String id) {
        return Optional.of(this.cartRepository.findOne(id)).get();
    }

    public Cart findByUserId(String userId) {
        return Optional.of(this.cartRepository.findByUserId(userId)).get();
    }
}
