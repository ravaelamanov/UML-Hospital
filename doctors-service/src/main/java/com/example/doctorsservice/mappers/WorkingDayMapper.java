package com.example.doctorsservice.mappers;

import com.example.doctorsservice.dtos.WorkingDayDTO;
import com.example.doctorsservice.model.WorkingDay;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkingDayMapper {
    WorkingDay toWorkingDay(WorkingDayDTO dto);
    WorkingDayDTO toWorkingDayDTO(WorkingDay entity);
}
