package ru.geekbrains.trade.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.trade.market.models.CartItem;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
}
