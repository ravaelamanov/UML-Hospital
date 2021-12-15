package com.example.doctorsservice.services;

import com.example.doctorsservice.exceptions.NotFoundException;
import com.example.doctorsservice.model.Doctor;
import com.example.doctorsservice.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) {
        doctorRepository.findById(doctor.getId()).orElseThrow(NotFoundException::new);
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findAll(Optional<Boolean> isAvailableOptional) {
        if (isAvailableOptional.isPresent()) {
            return doctorRepository.findDoctorByIsAvailable(isAvailableOptional.get());
        }
        else {
            return doctorRepository.findAll();
        }
    }
}
