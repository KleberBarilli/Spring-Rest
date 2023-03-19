package com.br.logistic.domain.services.occurrences;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.logistic.domain.model.Delivery;
import com.br.logistic.domain.model.Occurrence;
import com.br.logistic.domain.services.delivery.FindOneDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateOccurrenceService {

    private FindOneDeliveryService findOneDeliveryService;

    @Transactional
    public Occurrence execute(Long deliveryId, String description) {
        Delivery delivery = findOneDeliveryService.execute(deliveryId);

        return delivery.addOccurrence(description);
    }
}
