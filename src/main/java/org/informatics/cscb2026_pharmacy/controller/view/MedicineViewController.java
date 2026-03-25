package org.informatics.cscb2026_pharmacy.controller.view;

import lombok.RequiredArgsConstructor;
import org.informatics.cscb2026_pharmacy.dto.CreateMedicineDto;
import org.informatics.cscb2026_pharmacy.dto.MedicineDto;
import org.informatics.cscb2026_pharmacy.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/medicines")
public class MedicineViewController {
    private final MedicineService medicineService;

    @GetMapping
    public String getMedicines(Model model) {
        List<MedicineDto> medicines = this.medicineService.getMedicines();
        model.addAttribute("medicines", medicines);
        return "/medicines/medicines.html";
    }

    @GetMapping("/create-medicine")
    public String showCreateMedicineForm(Model model) {
        model.addAttribute("medicine", new MedicineDto());
        return "/medicines/create-medicine";
    }

    @PostMapping("/create")
    public String createMedicine(CreateMedicineDto medicine) {
        this.medicineService.createMedicine(medicine);
        return "redirect:/medicines";
    }

    @GetMapping("/edit-medicine/{id}")
    public String showEditMedicineForm(Model model, @PathVariable Long id) {
        model.addAttribute("medicine", this.medicineService.getMedicineById(id));
        return "/medicines/edit-medicine";
    }

    @PostMapping("/update/{id}")
    public String updateMedicine(@PathVariable long id, MedicineDto medicine) {
        this.medicineService.updateMedicine(medicine, id);
        return "redirect:/medicines";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable int id) {
        this.medicineService.deleteMedicine(id);
        return "redirect:/medicines";
    }
}



