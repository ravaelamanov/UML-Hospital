package com.example.dtos.cards;

import lombok.Data;

import java.util.List;

@Data
public class PrescriptionDTO {
    private Long id;

    private List<PrescriptionEntryDTO> entries;
}
