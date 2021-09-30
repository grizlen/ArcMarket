package ru.geekbrains.trade.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.trade.market.models.dtos.OrderItemDTO;
import ru.geekbrains.trade.market.services.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping
    public List<OrderItemDTO> getAll() {
        return ordersService.getAll();
    }

    @PostMapping("/{cartId}")
    public void addCartItem(@PathVariable Long cartId) {
        ordersService.addCartItem(cartId);
    }
}
