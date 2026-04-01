package org.informatics.cscb2026_pharmacy.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Medicine extends BaseEntity {

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 20")
    private String name;

    @DecimalMin(value = "0", message = "Price has to be greater than or equal to 0")
    private BigDecimal price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    @ManyToMany(mappedBy = "medicines")
    private Set<Recipe> recipes;
}
