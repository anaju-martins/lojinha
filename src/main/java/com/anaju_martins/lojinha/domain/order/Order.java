package com.anaju_martins.lojinha.domain.order;


import com.anaju_martins.lojinha.domain.user.User;
import com.anaju_martins.lojinha.domain.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name="orders")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDateTime moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name="clientId")
    private User client;

    public Order(){

    }

    public Order(String id, LocalDateTime moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
         setOrderStatus(orderStatus);
        this.client = client;
    }

    public Order(OrderStatus orderStatus, User client) {
        setOrderStatus(orderStatus);
        this.client = client;
    }


    public String getId() {
        return id;
    }

    @PrePersist
    public void prePersist(){
        this.moment = LocalDateTime.now();
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public User getClient() {
        return client;
    }


    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

