package com.example.dtos.appointments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AppointmentDTO {
    private Long id;

    private LocalDate date;

    private LocalTime time;

    private Status status;

    @JsonProperty("medical_card_id")
    private Long medicalCardId;

    @JsonProperty("doctor_id")
    private Long doctorId;

    public enum Status {
        PENDING,
        SUCCESS,
        FAILED
    }
}
