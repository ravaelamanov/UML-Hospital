package com.example.cardsservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class MedicalCard {
    @Id
    private Long id; // ОМС

    private LocalDateTime createdAt;

    private Long doctorId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private List<MedicalHistory> histories;

    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;

    @PrePersist
    private void prePersist() {
        createdAt = LocalDateTime.now();
    }

}
