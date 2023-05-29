package challenge.java.api.mapper;

import challenge.java.api.dto.DeliveryDto;
import challenge.java.api.model.Delivery;

import java.util.ArrayList;
import java.util.List;

public class DeliveryMapper {

    public static Delivery toEntity(DeliveryDto deliveryDto) {
        return new Delivery(deliveryDto.id(), deliveryDto.order(), deliveryDto.deliveryDate(), deliveryDto.status());
    }

    public static DeliveryDto toDto(Delivery delivery) {
        return new DeliveryDto(delivery.getId(), delivery.getOrder(), delivery.getDeliveryDate(), delivery.getStatus());
    }

    public static List<DeliveryDto> toDtoList(List<Delivery> deliveries) {
        List<DeliveryDto> deliveryDtos = new ArrayList<>();
        for (Delivery delivery : deliveries) {
            DeliveryDto deliveryDto = toDto(delivery);
            deliveryDtos.add(deliveryDto);
        }
        return deliveryDtos;
    }
}
