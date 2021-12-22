package com.example.dtos.cards;

import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class PrescriptionEntryDTO {
    private Long id;

    private String medicine;

    private int times;

    private TimeUnit timesUnit;

    private int duration;

    private TimeUnit durationUnit;
}
