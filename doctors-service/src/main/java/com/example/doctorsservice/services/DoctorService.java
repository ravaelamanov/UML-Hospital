package com.example.doctorsservice.services;

import com.example.doctorsservice.exceptions.NotFoundException;
import com.example.doctorsservice.model.Doctor;
import com.example.doctorsservice.repositories.DoctorRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<Doctor> findAll(Predicate predicate) {
        Iterable<Doctor> all = doctorRepository.findAll(predicate);
        List<Doctor> allList = new ArrayList<>();
        all.iterator().forEachRemaining(allList::add);
        return allList;
    }
}
