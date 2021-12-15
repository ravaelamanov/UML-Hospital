package com.example.doctorsservice.mappers;

import com.example.doctorsservice.dtos.ScheduleDTO;
import com.example.doctorsservice.model.Schedule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {WorkingDayMapperImpl.class, ScheduleMapperImpl.class})
class ScheduleMapperTest extends AbstractMapperTest {

    @Autowired
    private ScheduleMapper mapper;
    private static Schedule entity;
    private static ScheduleDTO dto;

    private static final int n = 5;

    @BeforeAll
    static void setup() {
        entity = createSchedule(5);
        dto = createScheduleDTO(5);
    }

    @Test
    void toSchedule() {
        Schedule schedule = mapper.toSchedule(dto);
        Assertions.assertNotNull(schedule.getWorkingDays());
        Assertions.assertEquals(n, schedule.getWorkingDays().size());
    }

    @Test
    void toScheduleDTO() {
        ScheduleDTO schedule = mapper.toScheduleDTO(entity);
        Assertions.assertNotNull(schedule.getWorkingDays());
        Assertions.assertEquals(n, schedule.getWorkingDays().size());
    }
}