package com.example.dtos.cards;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MedicalHistoryDTO {
    private Long id;

    private LocalDateTime openedAt;

    private LocalDateTime closedAt;

    private List<DiagnoseDTO> diagnoses;

    private List<SickLeaveDTO> sickLeave;

    private List<PrescriptionDTO> prescriptions;
}
