package com.anaju_martins.lojinha.domain.order;

import com.anaju_martins.lojinha.domain.enums.OrderStatus;
import com.anaju_martins.lojinha.domain.user.UserDTO;

import java.time.Instant;
import java.time.LocalDateTime;


public record OrderResponseDTO(String id, LocalDateTime moment, OrderStatus orderStatus, UserDTO client) {
    public OrderResponseDTO(Order order) {
        this(order.getId(), order.getMoment(), order.getOrderStatus(), new UserDTO(order.getClient()));
    }
}
