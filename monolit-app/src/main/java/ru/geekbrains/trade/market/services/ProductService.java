package ru.geekbrains.trade.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.trade.market.models.Product;
import ru.geekbrains.trade.market.models.dtos.ProductDTO;
import ru.geekbrains.trade.market.repositories.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    @Value("${products.pageSize:8}")
    private int pageSize;

    public Page<ProductDTO> getAll(Integer page) {
        PageRequest pr = PageRequest.of(page, pageSize);
        return productRepository.findAll(pr).map(this::productToDTO);
    }

    private ProductDTO productToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .build();
    }

    public ProductDTO getById(Long id) {
        return productToDTO(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with Id: " + id + "not found.")));
    }
}
