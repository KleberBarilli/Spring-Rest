package com.br.logistic.infra.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.logistic.domain.model.Delivery;
import com.br.logistic.infra.presenters.DeliveryPresenter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryMapper {
    private ModelMapper modelMapper;

    public DeliveryPresenter toHTTP(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryPresenter.class);
    }

    public List<DeliveryPresenter> toCollectionHTTP(List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toHTTP)
                .toList();
    }
}
