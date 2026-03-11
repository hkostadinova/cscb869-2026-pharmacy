package org.informatics.cscb2026_pharmacy.data.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Medicine extends BaseEntity {

    private String name;

    private BigDecimal price;

    private LocalDate expirationDate;
}
