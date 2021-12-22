package com.example.cardsservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.TimeUnit;

@Data
@Entity
public class PrescriptionEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicine;

    private int times;

    private TimeUnit timesUnit;

    private int duration;

    private TimeUnit durationUnit;
}
