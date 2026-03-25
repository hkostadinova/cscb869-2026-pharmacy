package org.informatics.cscb2026_pharmacy.data.repository;

import org.informatics.cscb2026_pharmacy.data.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    int countByDoctorNameContains(String name);
}
