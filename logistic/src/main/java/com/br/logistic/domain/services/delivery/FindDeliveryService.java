package com.br.logistic.domain.services.delivery;

import org.springframework.stereotype.Service;

import com.br.logistic.domain.exceptions.DomainNotFoundException;
import com.br.logistic.domain.model.Delivery;
import com.br.logistic.domain.repositories.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindDeliveryService {
    private DeliveryRepository deliveryRepository;

    public Delivery execute(Long deliveryId) {

        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new DomainNotFoundException("Delivery not found!"));
    }
}
