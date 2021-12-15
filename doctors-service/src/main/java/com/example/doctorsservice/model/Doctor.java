package com.example.doctorsservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String specialization;

    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

    private boolean isAvailable;

}
