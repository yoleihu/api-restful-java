package challenge.java.api.dto;

import challenge.java.api.model.Order;

import java.time.LocalDateTime;

public record DeliveryDto(Long id,
                          Order order,
                          LocalDateTime deliveryDate,
                          String status) {
}