package com.example.doctorsservice.mappers;

import com.example.doctorsservice.model.Schedule;
import com.example.dtos.doctors.ScheduleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {WorkingDayMapper.class})
public interface ScheduleMapper {
    Schedule toSchedule(ScheduleDTO dto);
    ScheduleDTO toScheduleDTO(Schedule entity);
}
