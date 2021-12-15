package com.example.doctorsservice.mappers;

import com.example.doctorsservice.dtos.ScheduleDTO;
import com.example.doctorsservice.model.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {WorkingDayMapper.class})
public interface ScheduleMapper {
    Schedule toSchedule(ScheduleDTO dto);
    ScheduleDTO toScheduleDTO(Schedule entity);
}
