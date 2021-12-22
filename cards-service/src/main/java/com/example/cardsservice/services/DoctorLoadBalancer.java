package com.example.cardsservice.services;

import com.example.cardsservice.repositories.MedicalCardRepository;
import com.example.dtos.doctors.DoctorWithIdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorLoadBalancer {
    private final MedicalCardRepository repository;
    private final DoctorClient doctorClient;

    private static final String GENERAL = "general";


    @Autowired
    public DoctorLoadBalancer(MedicalCardRepository repository, DoctorClient doctorClient) {
        this.repository = repository;
        this.doctorClient = doctorClient;
    }

    public Long loadBalance() {
        List<Long> doctorIds = getAvailableGeneralDoctorIds();

        if (doctorIds.isEmpty()) {
            throw new IllegalStateException("No doctors available!");
        }

        List<Long> counts = doctorIds.stream()
                .map(repository::getDoctorPatientCount)
                .collect(Collectors.toList());


//        return repository.getDoctorWithLowestPatientCount(doctorIds).orElse(doctorIds.stream().findFirst().orElseThrow());
        return doctorIds.get(counts.indexOf(Collections.min(counts)));
    }

    private List<Long> getAvailableGeneralDoctorIds() {
        return doctorClient.getDoctors(Boolean.TRUE, GENERAL).stream()
                .map(DoctorWithIdDTO::getId).collect(Collectors.toList());
    }


}
