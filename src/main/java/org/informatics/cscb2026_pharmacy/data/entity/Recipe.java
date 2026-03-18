package org.informatics.cscb2026_pharmacy.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Recipe extends BaseEntity {

    @Column(unique = true)
    private String recipeNumber;

    @Column
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @ManyToMany
    private Set<Medicine> medicines;
}
