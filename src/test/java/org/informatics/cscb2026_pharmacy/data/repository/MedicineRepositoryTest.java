package org.informatics.cscb2026_pharmacy.data.repository;

import org.informatics.cscb2026_pharmacy.data.entity.Medicine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MedicineRepositoryTest {

    @Autowired
    MedicineRepository medicineRepository;

    @Test
    void findByExpirationDateBefore () {
        Medicine medicine1 = Medicine.builder()
                .name("Analgin")
                .expirationDate(LocalDate.of(2026, 5,5))
                .build();
        Medicine medicine2 = Medicine.builder()
                .name("Aspirin")
                .expirationDate(LocalDate.of(2026, 5,6))
                .build();
        Medicine medicine3 = Medicine.builder()
                .name("Paracetamol")
                .expirationDate(LocalDate.of(2026, 5,7))
                .build();

        List<Medicine> expectedMedicines = List.of(medicine1, medicine2);
        medicineRepository.saveAll(List.of(medicine1, medicine2, medicine3));

        assertIterableEquals(expectedMedicines, medicineRepository.findByExpirationDateBefore(LocalDate.of(2026,5,7)));
    }
    @Test
    void countByExpirationDate() {
        Medicine medicine1 = Medicine.builder()
                .name("Analgin")
                .expirationDate(LocalDate.of(2026, 5,6))
                .build();
        Medicine medicine2 = Medicine.builder()
                .name("Aspirin")
                .expirationDate(LocalDate.of(2026, 5,6))
                .build();
        Medicine medicine3 = Medicine.builder()
                .name("Paracetamol")
                .expirationDate(LocalDate.of(2026, 5,7))
                .build();

        medicineRepository.saveAll(List.of(medicine1, medicine2, medicine3));

        assertEquals(2, medicineRepository.countByExpirationDate(LocalDate.of(2026,5,6)));
    }

}