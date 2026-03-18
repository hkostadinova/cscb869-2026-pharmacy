package org.informatics.cscb2026_pharmacy.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Medicine extends BaseEntity {

    private String name;

    private BigDecimal price;

    private LocalDate expirationDate;

    @ManyToMany(mappedBy = "medicines")
    private Set<Recipe> recipes;
}
