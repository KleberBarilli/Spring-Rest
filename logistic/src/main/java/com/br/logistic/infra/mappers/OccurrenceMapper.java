package com.br.logistic.infra.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.logistic.domain.model.Occurrence;
import com.br.logistic.infra.presenters.OccurrencePresenter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OccurrenceMapper {
    private ModelMapper modelMapper;

    public OccurrencePresenter toHTTP(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrencePresenter.class);
    }

    public List<OccurrencePresenter> toCollectionHTTP(List<Occurrence> occurrences) {
        return occurrences.stream()
                .map(this::toHTTP)
                .toList();
    }
}
