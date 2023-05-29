package challenge.java.api.dto;

import challenge.java.api.model.Customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderDto(Long id,
                       Customer customer,
                       LocalDateTime orderDate,
                       BigDecimal totalAmount ) {
}
