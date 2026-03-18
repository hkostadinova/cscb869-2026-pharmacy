package org.informatics.cscb2026_pharmacy.service;

import org.informatics.cscb2026_pharmacy.dto.CreateMedicineDto;
import org.informatics.cscb2026_pharmacy.dto.MedicineDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface MedicineService {
    List<MedicineDto> getMedicines();

    MedicineDto getMedicineById(long id);

    MedicineDto createMedicine(CreateMedicineDto createMedicineDto);

    MedicineDto updateMedicine(MedicineDto medicineDto, long id);

    void deleteMedicine(long id);

    List<MedicineDto> getExpiredMedicines();

    List<MedicineDto> findByExpirationDateBefore(LocalDate date);

    List<MedicineDto> findByNameStartingWith(String nameStart);

    List<MedicineDto> findByPriceGreaterThanOrExpirationDateBefore(BigDecimal priceGr, LocalDate expDate);

    List<MedicineDto> findByNameStartingWithIgnoreCase(String startName);

    List<MedicineDto> findByNameContainingOrderByExpirationDateDesc(String text);

    List<MedicineDto> findByPriceGreaterThanEqual(BigDecimal price);

    List<MedicineDto> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<MedicineDto> findByPriceGreaterThanAndExpirationDateAfter(BigDecimal price, LocalDate date);

    List<MedicineDto> findMedicinesByRecipe(Long recipeId);

    List<MedicineDto> findByRecipesCreationDate(LocalDate creationDate);

    long countByExpirationDate(LocalDate expirationDate);

    BigDecimal sumByPrice();

    List<MedicineDto> findByRecipeCreationDate(LocalDate creationDate);
}
