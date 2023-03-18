package com.br.logistic.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.logistic.domain.model.Delivery;
import com.br.logistic.domain.model.DeliveryStatus;
import com.br.logistic.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateDeliveryService {
    private DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery execute(Delivery delivery) {
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setOrderedAt(LocalDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
