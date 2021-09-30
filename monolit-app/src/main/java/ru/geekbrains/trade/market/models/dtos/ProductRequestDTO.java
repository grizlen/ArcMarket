package ru.geekbrains.trade.market.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductRequestDTO {
    private long id;
    private float quantity;
}
