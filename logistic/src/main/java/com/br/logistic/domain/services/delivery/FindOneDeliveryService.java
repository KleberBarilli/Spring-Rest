package com.br.logistic.domain.services.delivery;

import org.springframework.stereotype.Service;

import com.br.logistic.domain.exceptions.DomainException;
import com.br.logistic.domain.model.Delivery;
import com.br.logistic.domain.repositories.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindOneDeliveryService {
    private DeliveryRepository deliveryRepository;

    public Delivery execute(Long deliveryId) {

        return deliveryRepository.findById(deliveryId).orElseThrow(() -> new DomainException("Delivery not found!"));
    }
}
