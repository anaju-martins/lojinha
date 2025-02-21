package com.anaju_martins.lojinha.domain.order;

import com.anaju_martins.lojinha.domain.enums.OrderStatus;


public record OrderRequestDTO(OrderStatus orderStatus, String clientId) {
}
