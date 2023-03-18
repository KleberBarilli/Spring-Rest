package com.br.logistic.infra.presenters;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.br.logistic.domain.model.DeliveryStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryPresenter {
    private Long id;
    private String customerName;
    private RecipientPresenter recipient;
    private BigDecimal tax;
    private DeliveryStatus status;
    private OffsetDateTime orderDate;
    private OffsetDateTime orderCompletedDate;
}
