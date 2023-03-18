package com.br.logistic.infra.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.logistic.domain.model.Delivery;
import com.br.logistic.domain.repository.DeliveryRepository;
import com.br.logistic.domain.services.delivery.CreateDeliveryService;
import com.br.logistic.infra.presenters.DeliveryPresenter;
import com.br.logistic.infra.presenters.RecipientPresenter;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private CreateDeliveryService createDeliveryService;
    private DeliveryRepository deliveryRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public Delivery createDelivery(@Valid @RequestBody Delivery delivery) {
        return createDeliveryService.execute(delivery);
    }

    @GetMapping
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryPresenter> findOne(@PathVariable Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> {
                    DeliveryPresenter deliveryPresenter = new DeliveryPresenter();
                    deliveryPresenter.setId(deliveryId);
                    deliveryPresenter.setCustomerName(delivery.getCustomer().getName());
                    deliveryPresenter.setTax(delivery.getTax());
                    deliveryPresenter.setRecipient(new RecipientPresenter());
                    deliveryPresenter.getRecipient().setName(delivery.getRecipient().getName());
                    deliveryPresenter.getRecipient().setNeighborhood(delivery.getRecipient().getNeighborhood());
                    deliveryPresenter.getRecipient().setStreet(delivery.getRecipient().getStreet());
                    deliveryPresenter.getRecipient().setNumber(delivery.getRecipient().getNumber());
                    deliveryPresenter.getRecipient().setStreet(delivery.getRecipient().getStreet());
                    deliveryPresenter.setTax(delivery.getTax());
                    deliveryPresenter.setStatus(delivery.getStatus());
                    deliveryPresenter.setOrderDate(delivery.getOrderedAt());
                    deliveryPresenter.setOrderCompletedDate(delivery.getCompletedAt());

                    return ResponseEntity.ok(deliveryPresenter);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
