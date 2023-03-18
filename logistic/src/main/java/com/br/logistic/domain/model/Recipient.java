package com.br.logistic.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Recipient {
    @Column(name = "recipient_name")
    private String name;

    @Column(name = "recipient_street")
    private String street;

    @Column(name = "recipient_number")
    private String number;

    @Column(name = "recipient_neighborhood")
    private String neighborhood;
}
