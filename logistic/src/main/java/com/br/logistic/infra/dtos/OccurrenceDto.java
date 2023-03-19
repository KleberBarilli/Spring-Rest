package com.br.logistic.infra.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrenceDto {
    @NotBlank
    private String description;
}
