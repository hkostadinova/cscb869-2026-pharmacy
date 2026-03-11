package org.informatics.cscb2026_pharmacy.service;

import org.informatics.cscb2026_pharmacy.data.entity.Medicine;

import java.util.List;

public interface MedicineService {
    List<Medicine> getMedicines();

    Medicine getMedicineById(long id);

    Medicine createMedicine(Medicine medicine);

    Medicine updateMedicine(Medicine medicine, long id);

    void deleteMedicine(long id);
}
