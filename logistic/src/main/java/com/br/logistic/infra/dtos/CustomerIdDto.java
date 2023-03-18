package com.br.logistic.infra.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerIdDto {
    @NotNull
    private Long id;
}
