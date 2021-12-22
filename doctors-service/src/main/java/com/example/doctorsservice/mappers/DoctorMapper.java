package com.example.doctorsservice.mappers;

import com.example.doctorsservice.model.Doctor;
import com.example.dtos.doctors.DoctorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ScheduleMapper.class})
public interface DoctorMapper {
    Doctor toDoctor(DoctorDTO dto);
    DoctorDTO toDoctorDTO(Doctor entity);
}
