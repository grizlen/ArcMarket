package ru.geekbrains.trade.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.trade.market.models.CartItem;
import ru.geekbrains.trade.market.models.Product;
import ru.geekbrains.trade.market.models.dtos.CartItemDTO;
import ru.geekbrains.trade.market.models.dtos.ProductDTO;
import ru.geekbrains.trade.market.models.dtos.ProductRequestDTO;
import ru.geekbrains.trade.market.repositories.CartRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;

    public List<CartItemDTO> getCart() {
        return cartRepository.findAll().stream()
                .map(this::cartItemToDto)
                .collect(Collectors.toList());
    }

    public CartItemDTO getCartItem(Long id) {
        CartItem item = cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart item with id: " + id + " not found."));
        return cartItemToDto(item);
    }

    public void addProduct(ProductRequestDTO request) {
        List<CartItem> items = cartRepository.findAll()
                .stream()
                .filter(cartItem -> cartItem.getProductId() == request.getId())
                .collect(Collectors.toList());
        CartItem item;
        if (items.isEmpty()) {
            item = new CartItem();
            item.setProductId(request.getId());
            item.setQuantity(request.getQuantity());
        } else {
            item = items.get(0);
            while (items.size() > 1) {
                CartItem removed = items.remove(1);
                item.setQuantity(item.getQuantity() + removed.getQuantity());
                cartRepository.delete(removed);
            }
            item.setQuantity(item.getQuantity() + request.getQuantity());
        }
        cartRepository.save(item);
    }

    private CartItemDTO cartItemToDto(CartItem item) {
        ProductDTO product = productService.getById(item.getId());
        return CartItemDTO.builder()
                .id(item.getId())
                .productId(item.getProductId())
                .productTitle(product.getTitle())
                .quantity(item.getQuantity())
                .price(product.getPrice())
                .build();
    }

    public void deleteCartItem(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
