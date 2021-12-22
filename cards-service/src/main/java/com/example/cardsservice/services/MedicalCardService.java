package com.example.cardsservice.services;

import com.example.cardsservice.model.MedicalCard;
import com.example.cardsservice.repositories.MedicalCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MedicalCardService {
    private final MedicalCardRepository repository;
    private final DoctorLoadBalancer loadBalancer;

    @Autowired
    public MedicalCardService(MedicalCardRepository repository, DoctorLoadBalancer loadBalancer) {
        this.repository = repository;
        this.loadBalancer = loadBalancer;
    }


    public MedicalCard findCardById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MedicalCard createCard(MedicalCard medicalCard) {
        medicalCard.setDoctorId(loadBalancer.loadBalance());
        return repository.save(medicalCard);
    }

    public void updateCard(MedicalCard card) {
        requireNonNullCardId(card);
        requireCardExists(card);

        repository.save(card);
    }

    private void requireNonNullCardId(MedicalCard card) {
        Objects.requireNonNull(card.getId());
    }

    private void requireCardExists(MedicalCard medicalCard) {
        if (!repository.existsById(medicalCard.getId())) {
            throw new RuntimeException("Appointment doesn't exist!");
        }
    }
}
