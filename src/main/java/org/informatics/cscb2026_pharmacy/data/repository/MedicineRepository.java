package org.informatics.cscb2026_pharmacy.data.repository;

import org.informatics.cscb2026_pharmacy.data.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByExpirationDateBefore(LocalDate date);

    List<Medicine> findByNameStartingWith(String nameStart);

    List<Medicine> findByPriceGreaterThanOrExpirationDateBefore(BigDecimal priceGr, LocalDate expDate);

    List<Medicine> findByNameStartingWithIgnoreCase(String startName);

    List<Medicine> findByNameContainingOrderByExpirationDateDesc(String text);

    List<Medicine> findByPriceGreaterThanEqual(BigDecimal price);

    List<Medicine> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Medicine> findByPriceGreaterThanAndExpirationDateAfter(BigDecimal price, LocalDate date);

    @Query("SELECT m FROM Medicine m JOIN m.recipes r WHERE r.id = :recipeId")
    List<Medicine> findMedicinesByRecipe(@Param("recipeId") Long recipeId);

    List<Medicine> findByRecipesCreationDate(LocalDate localDate);

    long countByExpirationDate(LocalDate expirationDate);

    @Query("SELECT SUM(m.price) FROM Medicine m")
    BigDecimal sumByPrice();
}
