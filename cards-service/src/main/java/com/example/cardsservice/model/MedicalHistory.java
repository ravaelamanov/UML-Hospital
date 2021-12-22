package com.example.cardsservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime openedAt;

    private LocalDateTime closedAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "history_id")
    private List<Diagnose> diagnoses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "history_id")
    private List<SickLeave> sickLeave;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "history_id")
    private List<Prescription> prescriptions;

    @PreUpdate
    private void preUpdate() {
        if (closedAt == null) {
            diagnoses.stream()
                    .filter(diagnose -> diagnose.getType().equals(Diagnose.Type.FINAL))
                    .findFirst()
                    .ifPresent(ignored -> closedAt = LocalDateTime.now());
        }

    }
}
