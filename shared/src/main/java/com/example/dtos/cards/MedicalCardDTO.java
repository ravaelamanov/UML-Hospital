package com.example.dtos.cards;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MedicalCardDTO {
    @JsonProperty("oms")
    private Long id; // ОМС

    private LocalDateTime createdAt;

    private Long doctorId;

    private List<MedicalHistoryDTO> histories;

    private PatientDTO patient;
}
