package com.br.logistic.infra.presenters;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrencePresenter {
    private Long id;
    private String description;
    private OffsetDateTime createdAt;
}
