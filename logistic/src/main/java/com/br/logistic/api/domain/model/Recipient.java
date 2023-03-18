package com.br.logistic.api.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Recipient {
    @NotBlank
    @Column(name = "recipient_name")
    private String name;

    @NotBlank
    @Column(name = "recipient_street")
    private String street;

    @NotBlank
    @Column(name = "recipient_number")
    private String number;

    @NotBlank
    @Column(name = "recipient_neighborhood")
    private String neighborhood;
}
