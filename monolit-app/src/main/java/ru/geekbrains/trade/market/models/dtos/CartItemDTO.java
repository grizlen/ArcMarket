package ru.geekbrains.trade.market.models.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CartItemDTO {
    private Long id;
    private Long productId;
    private String productTitle;
    private Float quantity;
    private Float price;
    private Float amount;
}
