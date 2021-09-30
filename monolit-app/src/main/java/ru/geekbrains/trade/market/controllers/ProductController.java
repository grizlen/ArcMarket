package ru.geekbrains.trade.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.trade.market.models.dtos.ProductDTO;
import ru.geekbrains.trade.market.services.ProductService;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductDTO> getAll(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        return productService.getAll(page);
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.getById(id);
    }

}
