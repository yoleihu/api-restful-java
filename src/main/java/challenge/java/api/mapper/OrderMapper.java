package challenge.java.api.mapper;

import challenge.java.api.model.Order;
import challenge.java.api.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static Order toEntity(OrderDto orderDto) {
        return new Order(orderDto.id(), orderDto.customer(), orderDto.orderDate(), orderDto.totalAmount());
    }

    public static OrderDto toDto(Order order) {
        return new OrderDto(order.getId(), order.getCustomer(), order.getOrderDate(), order.getTotalAmount());
    }

    public static List<OrderDto> toDtoList(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = toDto(order);
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }
}
