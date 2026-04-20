package org.informatics.cscb2026_pharmacy.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.informatics.cscb2026_pharmacy.dto.MedicineDto;
import org.informatics.cscb2026_pharmacy.service.impl.MedicineServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MedicineApiController.class)
class MedicineApiControllerSampleTest {

    @MockitoBean
    private MedicineServiceImpl medicineService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(authorities = {"DOCTOR"})
    void createMedicineTest() throws Exception {
        MedicineDto medicine1 = Mockito.mock(MedicineDto.class);
        Mockito.when(medicine1.getName()).thenReturn("Analgin");
        Mockito.when(medicine1.getExpirationDate()).thenReturn(LocalDate.of(2026,5,5));

        Mockito.when(medicineService.createMedicine(any())).thenReturn(medicine1);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/medicines")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(medicine1)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.expirationDate", is(medicine1.getExpirationDate().toString())));
    }

    @Test
    @WithMockUser(authorities = {"DOCTOR"})
    void getMedicinesTest() throws Exception {
        MedicineDto medicine1 = MedicineDto.builder()
                .id(1L)
                .expirationDate(LocalDate.of(2026,05,05))
                .build();
        MedicineDto medicine2 = MedicineDto.builder()
                .id(2L)
                .expirationDate(LocalDate.of(2026,05,07))
                .build();
        List<MedicineDto> medicinesExpected = Arrays.asList(medicine1, medicine2);

        given(medicineService.getMedicines()).willReturn(medicinesExpected);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/medicines"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(medicine1.getId()), Long.class))
                .andExpect(jsonPath("$[0].expirationDate", is("2026-05-05")))
                .andExpect(jsonPath("$[1].id", is(medicine2.getId()), Long.class))
                .andExpect(jsonPath("$[1].expirationDate", is("2026-05-07")))
                .andDo(print());
    }

    @Test
    @WithMockUser(authorities = {"CUSTOMER"})
    void getMedicineByIdTest() throws Exception {
        MedicineDto medicine1 = MedicineDto.builder()
                .id(1L)
                .expirationDate(LocalDate.of(2026,05,05))
                .build();
        int medicineId = 1;

        Mockito.when(medicineService.getMedicineById(medicineId)).thenReturn(medicine1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/medicines/{medicineId}", medicineId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(medicine1.getId()), Long.class))
                .andExpect(jsonPath("$.expirationDate", is("2026-05-05")))
                .andDo(print());
    }
}