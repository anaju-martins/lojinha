package com.anaju_martins.lojinha.repositories;

import com.anaju_martins.lojinha.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
