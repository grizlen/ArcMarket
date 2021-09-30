package ru.geekbrains.trade.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.trade.market.models.OrderItem;
import ru.geekbrains.trade.market.models.Product;
import ru.geekbrains.trade.market.models.dtos.CartItemDTO;
import ru.geekbrains.trade.market.models.dtos.OrderItemDTO;
import ru.geekbrains.trade.market.models.dtos.ProductDTO;
import ru.geekbrains.trade.market.repositories.OrdersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final CartService cartService;
    private final ProductService productService;

    public List<OrderItemDTO> getAll() {
        return ordersRepository.findAll().stream().map(this::orderItemToDto).collect(Collectors.toList());
    }

    private OrderItemDTO orderItemToDto(OrderItem item) {
        ProductDTO product = productService.getById(item.getProductId());
        return OrderItemDTO.builder()
                .id(item.getId())
                .productId(item.getProductId())
                .productTitle(product.getTitle())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();
    }

    public void addCartItem(Long cartId) {
        CartItemDTO cartItem = cartService.getCartItem(cartId);
        ProductDTO product = productService.getById(cartItem.getProductId());
        OrderItem item = new OrderItem();
        item.setProductId(cartItem.getProductId());
        item.setQuantity(cartItem.getQuantity());
        item.setPrice(product.getPrice());
        item.setAmount(cartItem.getQuantity() * product.getPrice());
        cartService.deleteCartItem(cartId);
        ordersRepository.save(item);
    }
}
