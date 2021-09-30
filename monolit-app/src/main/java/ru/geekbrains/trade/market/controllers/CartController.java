package ru.geekbrains.trade.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.trade.market.models.dtos.Cart;
import ru.geekbrains.trade.market.models.dtos.CartItemDTO;
import ru.geekbrains.trade.market.models.dtos.ProductRequestDTO;
import ru.geekbrains.trade.market.services.CartService;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public Cart getCart() {
        Cart cart = new Cart(cartService.getCart());
        return cart;
    }

    @GetMapping("/{id}")
    public CartItemDTO getCartItem(@PathVariable Long id) {
        return cartService.getCartItem(id);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductRequestDTO request) {
        cartService.addProduct(request);
    }
}
