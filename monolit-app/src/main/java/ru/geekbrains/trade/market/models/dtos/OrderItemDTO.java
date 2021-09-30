package ru.geekbrains.trade.market.models.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItemDTO {
    private Long id;
    private long productId;
    private String productTitle;
    private Float quantity;
    private Float price;
    private Float amount;
}
