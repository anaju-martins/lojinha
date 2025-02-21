package com.anaju_martins.lojinha.controllers;

import com.anaju_martins.lojinha.domain.order.Order;
import com.anaju_martins.lojinha.domain.order.OrderRequestDTO;
import com.anaju_martins.lojinha.domain.order.OrderResponseDTO;
import com.anaju_martins.lojinha.domain.user.User;
import com.anaju_martins.lojinha.repositories.OrderRepository;
import com.anaju_martins.lojinha.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderDTO) {
        Optional<User> userOpt = userRepository.findById(orderDTO.clientId());

        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Confere se o user existe
        }

        User user = userOpt.get();

        LocalDateTime currentMoment = LocalDateTime.now();

        Order order = new Order(null, currentMoment, orderDTO.orderStatus(), user);
        order = orderRepository.save(order);

        return ResponseEntity.ok().body(new OrderResponseDTO(order)); // Converte order para orderDTO
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponseDTO> responseDTOs = orders.stream()
                .map(OrderResponseDTO::new) //retornando a lista de order como orderDTO
                .toList();

        return ResponseEntity.ok(responseDTOs);
    }



}
