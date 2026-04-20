package org.informatics.cscb2026_pharmacy.service.impl;

import org.informatics.cscb2026_pharmacy.config.ModelMapperConfig;
import org.informatics.cscb2026_pharmacy.data.entity.Medicine;
import org.informatics.cscb2026_pharmacy.data.repository.MedicineRepository;
import org.informatics.cscb2026_pharmacy.dto.MedicineDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class MedicineServiceImplSampleTest {

    @Mock
    Medicine medicine1;

    @Mock
    Medicine medicine2;

    @Mock
    MedicineRepository medicineRepository;

    @Mock
    ModelMapperConfig modelMapperConfig;

    @InjectMocks
    MedicineServiceImpl medicineService;

    @Test
    void medicineServiceGetMedicinesTest() {
        Mockito.when(medicine1.getName()).thenReturn("Analgin");

        Mockito.when(medicine2.getName()).thenReturn("Analgin");

        Mockito.when(modelMapperConfig.mapList(any(), any())).thenReturn(List.of(medicine1, medicine2));

        assertEquals(2, medicineService.getMedicines().size());
    }
}