package org.informatics.cscb2026_pharmacy.service.impl;

import lombok.AllArgsConstructor;
import org.informatics.cscb2026_pharmacy.data.entity.Medicine;
import org.informatics.cscb2026_pharmacy.data.repository.MedicineRepository;
import org.informatics.cscb2026_pharmacy.service.MedicineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getMedicines() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine getMedicineById(long id) {
        return medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found!"));
    }

    @Override
    public Medicine createMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public Medicine updateMedicine(Medicine medicine, long id) {
        Medicine updatedMedicine = this.getMedicineById(id);
        updatedMedicine.setName(medicine.getName());
        updatedMedicine.setExpirationDate(medicine.getExpirationDate());
        return medicineRepository.save(updatedMedicine);
    }

    public void deleteMedicine(long id) {
        medicineRepository.deleteById(id);
    }
}
