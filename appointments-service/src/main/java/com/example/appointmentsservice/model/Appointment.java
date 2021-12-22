package com.example.appointmentsservice.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalTime time;

    private Status status;

    private Long medicalCardId;

    private Long doctorId;

    public enum Status {
        PENDING,
        SUCCESS,
        FAILED
    }

    @PrePersist
    private void prePersist() {
        status = Status.PENDING;
    }
}
