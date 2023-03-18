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
import com.br.logistic.domain.repositories.DeliveryRepository;
import com.br.logistic.domain.services.delivery.CreateDeliveryService;
import com.br.logistic.infra.dtos.DeliveryDto;
import com.br.logistic.infra.mappers.DeliveryMapper;
import com.br.logistic.infra.presenters.DeliveryPresenter;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private CreateDeliveryService createDeliveryService;
    private DeliveryRepository deliveryRepository;
    private DeliveryMapper deliveryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public DeliveryPresenter createDelivery(@Valid @RequestBody DeliveryDto deliveryDto) {
        Delivery newDelivery = deliveryMapper.toDomain(deliveryDto);
        return deliveryMapper.toHTTP(createDeliveryService.execute(newDelivery));
    }

    @GetMapping
    public List<DeliveryPresenter> findAll() {
        return deliveryMapper.toCollectionHTTP(deliveryRepository.findAll());
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryPresenter> findOne(@PathVariable Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toHTTP(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }
}
