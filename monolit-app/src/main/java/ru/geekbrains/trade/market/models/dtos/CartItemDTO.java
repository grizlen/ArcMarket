package ru.geekbrains.trade.market.models.dtos;

//import lombok.Builder;
import lombok.Getter;

//@Builder
@Getter
public class CartItemDTO {
    private Long id;
    private Long productId;
    private String productTitle;
    private Float quantity;
    private Float price;
    private Float amount;

    public static CartItemDTOBuilder builder() {
        return new CartItemDTOBuilder();
    }

    public static class CartItemDTOBuilder {
        private final CartItemDTO result;

        public CartItemDTOBuilder() {
            result = new CartItemDTO();
        }

        public CartItemDTOBuilder id(Long id) {
            result.id = id;
            return this;
        }

        public CartItemDTOBuilder productId(Long productId) {
            result.productId = productId;
            return this;
        }

        public CartItemDTOBuilder productTitle(String productTitle) {
            result.productTitle = productTitle;
            return this;
        }

        public CartItemDTOBuilder quantity(Float quantity) {
            result.quantity = quantity;
            return this;
        }

        public CartItemDTOBuilder price(Float price) {
            result.price = price;
            return this;
        }

        public CartItemDTO build() {
            result.amount = result.quantity != null && result.price != null ? result.quantity * result.price : 0;
            return result;
        }
    }
}
