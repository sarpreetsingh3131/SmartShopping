package org.cart.query.service.service;

import org.cart.domain.service.dao.CartDaoForEndUser;
import org.cart.domain.service.model.Cart;
import org.cart.domain.service.repository.CartRepository;
import org.cart.domain.service.repository.ProductRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class QueryService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public QueryService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public List<CartDaoForEndUser> findAllCarts() {
        List<CartDaoForEndUser> cartDaoForEndUsers = new LinkedList<>();
        List<Cart> carts = this.cartRepository.findAll();
        carts.forEach(cart ->
                cartDaoForEndUsers.add(new CartDaoForEndUser(cart.getUserId(), this.productRepository.findByUserId(cart.getUserId()))));
        return cartDaoForEndUsers;
    }

    public CartDaoForEndUser findCartByUserId(String userId) {
        Cart cart = Optional
                .of(this.cartRepository.findByUserId(userId))
                .orElseThrow(() -> new NoSuchElementException("No cart with userId = " + userId));
        return new CartDaoForEndUser(cart.getUserId(), this.productRepository.findByUserId(cart.getUserId()));
    }
}
