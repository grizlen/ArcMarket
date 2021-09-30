package ru.geekbrains.trade.market.models.dtos;

//import lombok.Builder;
import lombok.Getter;

//@Builder
@Getter
public class ProductDTO {
    private Long id;
    private String title;
    private Float price;

    public static ProductDTOBuilder builder() {
        return new ProductDTOBuilder();
    }

    public static class ProductDTOBuilder {
        private final ProductDTO result;

        public ProductDTOBuilder() {
            result = new ProductDTO();
        }

        public ProductDTOBuilder id(Long id) {
            result.id = id;
            return this;
        }

        public ProductDTOBuilder title(String title) {
            result.title = title;
            return this;
        }

        public ProductDTOBuilder price(Float price) {
            result.price = price;
            return this;
        }

        public ProductDTO build() {
            return result;
        }
    }
}
