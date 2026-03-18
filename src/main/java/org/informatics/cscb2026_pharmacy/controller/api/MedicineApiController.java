package org.informatics.cscb2026_pharmacy.controller.api;

import lombok.AllArgsConstructor;
import org.informatics.cscb2026_pharmacy.dto.CreateMedicineDto;
import org.informatics.cscb2026_pharmacy.dto.MedicineDto;
import org.informatics.cscb2026_pharmacy.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@AllArgsConstructor
public class MedicineApiController {

    private final MedicineService medicineService;

    @GetMapping
    public List<MedicineDto> getMedicines() {
        return medicineService.getMedicines();
    }

    @GetMapping("/{id}")
    public MedicineDto getMedicineById(@PathVariable long id) {
        return medicineService.getMedicineById(id);
    }

    @PostMapping
    public MedicineDto createMedicine(@RequestBody CreateMedicineDto medicineDto) {
        return medicineService.createMedicine(medicineDto);
    }

    @PutMapping("/{id}")
    public MedicineDto updateMedicine(@RequestBody MedicineDto medicineDto, @PathVariable long id) {
        return medicineService.updateMedicine(medicineDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable long id) {
        medicineService.deleteMedicine(id);
    }

    @GetMapping("/expired")
    public List<MedicineDto> getExpiredMedicines() {
        return medicineService.getExpiredMedicines();
    }

    @GetMapping("/by-expiration-before/{date}")
    public List<MedicineDto> findByExpirationDateBefore(@PathVariable LocalDate date) {
        return medicineService.findByExpirationDateBefore(date);
    }

    @GetMapping("/by-name-starting-with/{nameStart}")
    public List<MedicineDto> findByNameStartingWith(@PathVariable String nameStart) {
        return medicineService.findByNameStartingWith(nameStart);
    }

    @GetMapping("/by-price-greater-than-or-expiration-before/{priceGr}/{expDate}")
    public List<MedicineDto> findByPriceGreaterThanOrExpirationDateBefore(
            @PathVariable BigDecimal priceGr,
            @PathVariable LocalDate expDate
    ) {
        return medicineService.findByPriceGreaterThanOrExpirationDateBefore(priceGr, expDate);
    }

    @GetMapping("/by-name-starts/{nameStart}")
    public List<MedicineDto> findByNameStartingWithIgnoreCase(@PathVariable String nameStart) {
        return medicineService.findByNameStartingWithIgnoreCase(nameStart);
    }

    @GetMapping("/search-by-name/{text}")
    public List<MedicineDto> findByNameContainingOrderByExpirationDateDesc(@PathVariable String text) {
        return medicineService.findByNameContainingOrderByExpirationDateDesc(text);
    }

    @GetMapping("/by-price-greater-than-equal/{price}")
    public List<MedicineDto> findByPriceGreaterThanEqual(@PathVariable BigDecimal price) {
        return medicineService.findByPriceGreaterThanEqual(price);
    }

    @GetMapping("/by-price-between/{minPrice}/{maxPrice}")
    public List<MedicineDto> findByPriceBetween(@PathVariable BigDecimal minPrice, @PathVariable BigDecimal maxPrice) {
        return medicineService.findByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/by-price-greater-than-and-expiration-after/{price}/{date}")
    public List<MedicineDto> findByPriceGreaterThanAndExpirationDateAfter(
            @PathVariable BigDecimal price,
            @PathVariable LocalDate date
    ) {
        return medicineService.findByPriceGreaterThanAndExpirationDateAfter(price, date);
    }

    @GetMapping("/by-recipe/{recipeId}")
    public List<MedicineDto> findMedicinesByRecipe(@PathVariable Long recipeId) {
        return medicineService.findMedicinesByRecipe(recipeId);
    }

    @GetMapping("by-recipe-date/{creationDate}")
    public List<MedicineDto> findByRecipesCreationDate(@PathVariable LocalDate creationDate) {
        return medicineService.findByRecipesCreationDate(creationDate);
    }

    @GetMapping("/count-by-expiration-date/{expirationDate}")
    public long countByExpirationDate(@PathVariable LocalDate expirationDate) {
        return medicineService.countByExpirationDate(expirationDate);
    }

    @GetMapping("/sum-by-price")
    public BigDecimal sumByPrice() {
        return medicineService.sumByPrice();
    }

    @GetMapping("/by-recipe-creation-date/{creationDate}")
    public List<MedicineDto> findByRecipeCreationDate(@PathVariable LocalDate creationDate) {
        return medicineService.findByRecipeCreationDate(creationDate);
    }
}
