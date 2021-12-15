package com.example.doctorsservice.controllers;

import com.example.doctorsservice.dtos.DoctorDTO;
import com.example.doctorsservice.dtos.DoctorWithIdDTO;
import com.example.doctorsservice.mappers.DoctorMapper;
import com.example.doctorsservice.model.Doctor;
import com.example.doctorsservice.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
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
    public List<DoctorWithIdDTO> getDoctors(@RequestParam("available") Optional<Boolean> isAvailable) {
        return doctorService.findAll(isAvailable).stream()
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
