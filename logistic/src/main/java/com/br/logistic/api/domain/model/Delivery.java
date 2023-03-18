package com.br.logistic.api.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.br.logistic.api.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "deliveries")
public class Delivery {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.CustomerId.class)
    @NotNull
    @ManyToOne
    private Customer customer;

    private BigDecimal tax;

    @Embedded
    private Recipient recipient;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = Access.READ_ONLY)
    private DeliveryStatus status;

    @Column(name = "ordered_at")
    @JsonProperty(access = Access.READ_ONLY)
    private OffsetDateTime orderedAt;

    @Column(name = "completed_at")
    @JsonProperty(access = Access.READ_ONLY)
    private OffsetDateTime completedAt;
}
