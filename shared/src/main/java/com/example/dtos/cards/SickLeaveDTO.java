package com.example.dtos.cards;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SickLeaveDTO {
    private Long id;
    private LocalDate start;
    private LocalDate finish;
}
