package com.example.doctorsservice.mappers;

import com.example.doctorsservice.model.WorkingDay;
import com.example.dtos.doctors.WorkingDayDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalTime;

class WorkingDayMapperTest extends AbstractMapperTest {

    private final WorkingDayMapper mapper = Mappers.getMapper(WorkingDayMapper.class);
    private static WorkingDay entity;
    private static WorkingDayDTO dto;

    private static final Long ID = 1L;
    private static final int DAY = 0;
    private static final LocalTime START = LocalTime.parse("08:00");
    private static final LocalTime FINISH = LocalTime.parse("17:00");


    @BeforeAll
    static void setup() {
        entity = createWorkingDay(ID, DAY, START, FINISH);
        dto = createWorkingDayDTO(DAY, START, FINISH);
    }

    @Test
    void toWorkingDayDTO() {
        var mappedDTO = mapper.toWorkingDayDTO(entity);
        Assertions.assertEquals(DAY, mappedDTO.getDay());
        Assertions.assertEquals(START, mappedDTO.getStart());
        Assertions.assertEquals(FINISH, mappedDTO.getFinish());
    }

    @Test
    void toWorkingDay() {
        var mappedEntity = mapper.toWorkingDay(dto);
        Assertions.assertEquals(DAY, mappedEntity.getDay());
        Assertions.assertEquals(START, mappedEntity.getStart());
        Assertions.assertEquals(FINISH, mappedEntity.getFinish());
    }
}