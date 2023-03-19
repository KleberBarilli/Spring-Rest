package com.br.logistic.infra.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.logistic.domain.services.occurrences.CreateOccurrenceService;
import com.br.logistic.infra.dtos.OccurrenceDto;
import com.br.logistic.infra.mappers.OccurrenceMapper;
import com.br.logistic.infra.presenters.OccurrencePresenter;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("deliveries/{deliveryId}/occurrences")
public class OccurrenceController {

    private CreateOccurrenceService createOccurrenceService;
    private OccurrenceMapper occurrenceMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrencePresenter register(@PathVariable Long deliveryId,
            @Valid @RequestBody OccurrenceDto occurrenceDto) {
        return occurrenceMapper.toHTTP(createOccurrenceService.execute(deliveryId, occurrenceDto.getDescription()));
    }
}
