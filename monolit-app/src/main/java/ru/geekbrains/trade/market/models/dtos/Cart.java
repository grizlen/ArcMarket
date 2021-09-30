package ru.geekbrains.trade.market.models.dtos;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class Cart {
    private final List<CartItemDTO> items;
    private final int count;
    private final float total;

    public Cart(List<CartItemDTO> list) {
        items = Collections.unmodifiableList(list);
        count = list.size();
        total = list.stream()
                .map(i -> i.getAmount())
                .reduce((a, b) -> a + b)
                .orElse(0f);
    }
}
