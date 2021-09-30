package ru.geekbrains.trade.market.models.dtos;

//import lombok.Builder;
import lombok.Getter;

@Getter
//@Builder
public class OrderItemDTO {
    private Long id;
    private long productId;
    private String productTitle;
    private Float quantity;
    private Float price;
    private Float amount;

    public static OrderItemDTOBuilder builder() {
        return new OrderItemDTOBuilder();
    }

    public static class OrderItemDTOBuilder {
        private final OrderItemDTO result;

        public OrderItemDTOBuilder() {
            result = new OrderItemDTO();
        }

        public OrderItemDTOBuilder id(Long id) {
            result.id = id;
            return this;
        }

        public OrderItemDTOBuilder productId(Long productId) {
            result.productId = productId;
            return this;
        }

        public OrderItemDTOBuilder productTitle(String productTitle) {
            result.productTitle = productTitle;
            return this;
        }

        public OrderItemDTOBuilder quantity(Float quantity) {
            result.quantity = quantity;
            return this;
        }

        public OrderItemDTOBuilder price(Float price) {
            result.price = price;
            return this;
        }

        public OrderItemDTO build() {
            result.amount = result.quantity != null && result.price != null ? result.quantity * result.price : 0;
            return result;
        }
    }
}
