package com.example.appointmentsservice.mappers;

import com.example.appointmentsservice.model.Appointment;
import com.example.dtos.appointments.AppointmentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper extends IMapper<Appointment, AppointmentDTO> {
}
