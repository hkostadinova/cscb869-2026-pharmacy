package org.informatics.cscb2026_pharmacy.controller.api;

import lombok.AllArgsConstructor;
import org.informatics.cscb2026_pharmacy.data.entity.Medicine;
import org.informatics.cscb2026_pharmacy.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
@AllArgsConstructor
public class MedicineApiController {

    private final MedicineService medicineService;

    @GetMapping
    public List<Medicine> getMedicines() {
        return medicineService.getMedicines();
    }

    @GetMapping("/{id}")
    public Medicine getMedicineById(@PathVariable long id) {
        return medicineService.getMedicineById(id);
    }
    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.createMedicine(medicine);
    }
    @PutMapping("/{id}")
    public Medicine updateMedicine(@RequestBody Medicine medicine, @PathVariable long id) {
        return medicineService.updateMedicine(medicine, id);
    }
    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable long id) {
        medicineService.deleteMedicine(id);
    }
}
