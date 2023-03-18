package com.br.logistic.domain.services.delivery;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.logistic.domain.model.Customer;
import com.br.logistic.domain.model.Delivery;
import com.br.logistic.domain.model.DeliveryStatus;
import com.br.logistic.domain.repositories.DeliveryRepository;
import com.br.logistic.domain.services.customer.FindCustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateDeliveryService {
    private DeliveryRepository deliveryRepository;

    private FindCustomerService findCustomerService;

    @Transactional
    public Delivery execute(Delivery delivery) {
        Customer customer = findCustomerService.execute(delivery.getCustomer().getId());

        delivery.setCustomer(customer);
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setOrderedAt(OffsetDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
