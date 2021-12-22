package com.example.doctorsservice.controllers;

import com.example.doctorsservice.mappers.DoctorMapper;
import com.example.doctorsservice.model.Doctor;
import com.example.doctorsservice.services.DoctorService;
import com.example.dtos.doctors.DoctorDTO;
import com.example.dtos.doctors.DoctorWithIdDTO;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorController(DoctorService doctorService, DoctorMapper doctorMapper) {
        this.doctorService = doctorService;
        this.doctorMapper = doctorMapper;
    }


    @GetMapping
    public List<DoctorWithIdDTO> getDoctors(@QuerydslPredicate(root = Doctor.class) Predicate predicate) {
        return doctorService.findAll(predicate).stream()
                .map(this::toDoctorWithIdDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorWithIdDTO findDoctor(@PathVariable Long id) {
        Doctor doctor = doctorService.findById(id);
        return toDoctorWithIdDTO(doctor);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorWithIdDTO createDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toDoctor(doctorDTO);
        Doctor savedDoctor = doctorService.createDoctor(doctor);
        return toDoctorWithIdDTO(savedDoctor);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDoctor(@PathVariable Long id, @RequestBody @Valid DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toDoctor(doctorDTO);
        doctor.setId(id);
        doctorService.updateDoctor(doctor);
    }

    private DoctorWithIdDTO toDoctorWithIdDTO(Doctor doctor) {
        DoctorDTO doctorDTO = doctorMapper.toDoctorDTO(doctor);
        DoctorWithIdDTO doctorWithIdDTO = new DoctorWithIdDTO();
        doctorWithIdDTO.setId(doctor.getId());
        doctorWithIdDTO.setDoctorDetails(doctorDTO);

        return doctorWithIdDTO;
    }

    private Doctor toDoctor(DoctorWithIdDTO doctorWithIdDTO) {
        Doctor doctor = doctorMapper.toDoctor(doctorWithIdDTO.getDoctorDetails());
        doctor.setId(doctorWithIdDTO.getId());

        return doctor;
    }


}
