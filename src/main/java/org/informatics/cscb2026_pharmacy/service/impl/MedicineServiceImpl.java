package org.informatics.cscb2026_pharmacy.service.impl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.informatics.cscb2026_pharmacy.config.ModelMapperConfig;
import org.informatics.cscb2026_pharmacy.data.entity.Medicine;
import org.informatics.cscb2026_pharmacy.data.repository.MedicineRepository;
import org.informatics.cscb2026_pharmacy.dto.CreateMedicineDto;
import org.informatics.cscb2026_pharmacy.dto.MedicineDto;
import org.informatics.cscb2026_pharmacy.service.MedicineService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final ModelMapperConfig modelMapperConfig;

    @Override
    public List<MedicineDto> getMedicines() {
        return modelMapperConfig.mapList(medicineRepository.findAll(), MedicineDto.class);
    }

    @Override
    public MedicineDto getMedicineById(long id) {
        return modelMapperConfig.modelMapper().map(medicineRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Id not found!"))
                , MedicineDto.class);
    }

    @Override
    public MedicineDto createMedicine(@Valid CreateMedicineDto createMedicineDto) {
        Medicine medicine = modelMapperConfig.modelMapper().map(createMedicineDto, Medicine.class);
        return modelMapperConfig.modelMapper().map(medicineRepository.save(medicine), MedicineDto.class);
    }

    @Override
    public MedicineDto updateMedicine(@Valid MedicineDto medicineDto, long id) {
        Medicine updatedMedicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found!"));
        updatedMedicine.setName(medicineDto.getName());
        updatedMedicine.setPrice(medicineDto.getPrice());
        updatedMedicine.setExpirationDate(medicineDto.getExpirationDate());
        return modelMapperConfig.modelMapper().map(medicineRepository.save(updatedMedicine), MedicineDto.class);
    }

    @Override
    public void deleteMedicine(long id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public List<MedicineDto> getExpiredMedicines() {
        return modelMapperConfig.mapList(medicineRepository.findByExpirationDateBefore(LocalDate.now()), MedicineDto.class);
    }

    @Override
    public List<MedicineDto> findByExpirationDateBefore(LocalDate date) {
        return modelMapperConfig.mapList(medicineRepository.findByExpirationDateBefore(date), MedicineDto.class);
    }

    @Override
    public List<MedicineDto> findByNameStartingWith(String nameStart) {
        return modelMapperConfig.mapList(medicineRepository.findByNameStartingWith(nameStart), MedicineDto.class);
    }

    @Override
    public List<MedicineDto> findByPriceGreaterThanOrExpirationDateBefore(BigDecimal priceGr, LocalDate expDate) {
        return modelMapperConfig.mapList(
                medicineRepository.findByPriceGreaterThanOrExpirationDateBefore(priceGr, expDate),
                MedicineDto.class
        );
    }

    @Override
    public List<MedicineDto> findByNameStartingWithIgnoreCase(String startName) {
        return modelMapperConfig.mapList(medicineRepository.findByNameStartingWithIgnoreCase(startName), MedicineDto.class);
    }

    @Override
    public List<MedicineDto> findByNameContainingOrderByExpirationDateDesc(String text) {
        return modelMapperConfig.mapList(medicineRepository.findByNameContainingOrderByExpirationDateDesc(text), MedicineDto.class);
    }

    @Override
    public List<MedicineDto> findByPriceGreaterThanEqual(BigDecimal price) {
        return modelMapperConfig.mapList(medicineRepository.findByPriceGreaterThanEqual(price), MedicineDto.class);
    }

    @Override
    public List<MedicineDto> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return modelMapperConfig.mapList(medicineRepository.findByPriceBetween(minPrice, maxPrice), MedicineDto.class);
    }

    @Override
    public List<MedicineDto> findByPriceGreaterThanAndExpirationDateAfter(BigDecimal price, LocalDate date) {
        return modelMapperConfig.mapList(
                medicineRepository.findByPriceGreaterThanAndExpirationDateAfter(price, date),
                MedicineDto.class
        );
    }

    @Override
    public List<MedicineDto> findMedicinesByRecipe(Long recipeId) {
        return modelMapperConfig.mapList(medicineRepository.findMedicinesByRecipe(recipeId), MedicineDto.class);
    }

    @Override
    public List<MedicineDto> findByRecipesCreationDate(LocalDate creationDate) {
        return modelMapperConfig.mapList(medicineRepository.findByRecipesCreationDate(creationDate), MedicineDto.class);
    }

    @Override
    public long countByExpirationDate(LocalDate expirationDate) {
        return medicineRepository.countByExpirationDate(expirationDate);
    }

    @Override
    public BigDecimal sumByPrice() {
        return medicineRepository.sumByPrice();
    }

    @Override
    public List<MedicineDto> findByRecipeCreationDate(LocalDate creationDate) {
        return modelMapperConfig.mapList(medicineRepository.findByRecipesCreationDate(creationDate), MedicineDto.class);
    }
}
