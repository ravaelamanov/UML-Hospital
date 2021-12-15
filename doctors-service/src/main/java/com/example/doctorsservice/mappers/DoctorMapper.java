package com.example.doctorsservice.mappers;

import com.example.doctorsservice.dtos.DoctorDTO;
import com.example.doctorsservice.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ScheduleMapper.class})
public interface DoctorMapper {
    Doctor toDoctor(DoctorDTO dto);
    DoctorDTO toDoctorDTO(Doctor entity);
}
