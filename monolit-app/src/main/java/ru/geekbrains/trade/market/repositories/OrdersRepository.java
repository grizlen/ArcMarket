package ru.geekbrains.trade.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.trade.market.models.OrderItem;

@Repository
public interface OrdersRepository extends JpaRepository<OrderItem, Long> {
}
