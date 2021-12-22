package com.example.doctorsservice.mappers;

import com.example.doctorsservice.model.WorkingDay;
import com.example.dtos.doctors.WorkingDayDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkingDayMapper {
    WorkingDay toWorkingDay(WorkingDayDTO dto);
    WorkingDayDTO toWorkingDayDTO(WorkingDay entity);
}
