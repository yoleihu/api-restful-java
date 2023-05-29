package challenge.java.api.service;

import challenge.java.api.model.Delivery;
import challenge.java.api.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long id) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);
        return optionalDelivery.orElse(null);
    }

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDelivery(Long id, Delivery delivery) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);
        if (optionalDelivery.isPresent()) {
            Delivery existingDelivery = optionalDelivery.get();
            existingDelivery.setOrder(delivery.getOrder());
            existingDelivery.setDeliveryDate(delivery.getDeliveryDate());
            existingDelivery.setStatus(delivery.getStatus());
            return deliveryRepository.save(existingDelivery);
        } else {
            return null;
        }
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }
}
