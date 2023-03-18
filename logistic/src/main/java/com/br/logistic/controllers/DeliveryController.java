package com.br.logistic.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.logistic.domain.model.Delivery;
import com.br.logistic.domain.services.delivery.CreateDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private CreateDeliveryService createDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return createDeliveryService.execute(delivery);
    }
}
