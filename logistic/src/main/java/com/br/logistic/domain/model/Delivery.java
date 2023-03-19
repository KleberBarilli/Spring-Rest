package com.br.logistic.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import com.br.logistic.domain.exceptions.DomainException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    @ManyToOne
    private Customer customer;

    private BigDecimal tax;

    @Embedded
    private Recipient recipient;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private OffsetDateTime orderedAt;

    private OffsetDateTime completedAt;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences;

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);
        occurrence.setCreatedAt(OffsetDateTime.now());
        occurrence.setDelivery(this);

        this.getOccurrences().add(occurrence);

        return occurrence;
    }

    public void finalize() {
        if (!canBeFinalized()) {
            throw new DomainException("Delivery does not be finalized!");
        }
        setStatus(DeliveryStatus.COMPLETED);
        setCompletedAt(OffsetDateTime.now());
    }

    public boolean canBeFinalized() {
        return DeliveryStatus.PENDING.equals(getStatus());
    }
}
