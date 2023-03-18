package com.br.logistic.infra.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private CreateDeliveryService createDeliveryService;
    private DeliveryRepository deliveryRepository;
    private ModelMapper modelMapper;

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
                    DeliveryPresenter deliveryPresenter = modelMapper.map(delivery, DeliveryPresenter.class);

                    return ResponseEntity.ok(deliveryPresenter);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
