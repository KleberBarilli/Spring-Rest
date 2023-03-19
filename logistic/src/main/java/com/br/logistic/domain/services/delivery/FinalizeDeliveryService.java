package com.br.logistic.domain.services.delivery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.logistic.domain.model.Delivery;
import com.br.logistic.domain.repositories.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizeDeliveryService {

    private FindDeliveryService findDeliveryService;
    private DeliveryRepository deliveryRepository;

    @Transactional
    public void execute(Long deliveryId) {

        Delivery delivery = findDeliveryService.execute(deliveryId);

        delivery.finalize();

        deliveryRepository.save(delivery);
    }
}
