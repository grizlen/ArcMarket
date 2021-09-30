package ru.geekbrains.trade.market.models.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductDTO {
    private Long id;
    private String title;
    private Float price;
}
