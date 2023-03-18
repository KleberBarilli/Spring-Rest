package com.br.logistic.infra.dtos;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDto {

    @Valid
    @NotNull
    private CustomerIdDto customer;

    @Valid
    @NotNull
    private RecipientDto recipient;

    @NotNull
    private BigDecimal tax;
}
