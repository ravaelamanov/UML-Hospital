package com.example.appointmentsservice.controllers;

import com.example.appointmentsservice.mappers.AppointmentMapper;
import com.example.appointmentsservice.model.Appointment;
import com.example.appointmentsservice.services.AppointmentService;
import com.example.dtos.appointments.AppointmentDTO;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentMapper mapper;
    private final AppointmentService service;

    @Autowired
    public AppointmentController(AppointmentMapper mapper, AppointmentService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public List<AppointmentDTO> getAppointments(@QuerydslPredicate(root = Appointment.class) Predicate predicate) {
        return service.findAll(predicate).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentDTO createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return mapper.toDTO(
                service.createAppointment(
                        mapper.toEntity(appointmentDTO)
                ));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO dto) {
        dto.setId(id);
        service.updateAppointment(mapper.toEntity(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void cancelAppointment(@PathVariable Long id) {
        service.cancelAppointment(id);
    }
}
