package com.example.doctorsservice.mappers;

import com.example.doctorsservice.model.Doctor;
import com.example.dtos.doctors.DoctorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DoctorMapperImpl.class, ScheduleMapperImpl.class, WorkingDayMapperImpl.class})
class DoctorMapperTest extends AbstractMapperTest {

    @Autowired
    private DoctorMapper mapper;

    private static Doctor entity;
    private static DoctorDTO dto;

    private final static String FIRST_NAME = "FIRST_NAME";
    private final static String LAST_NAME = "LAST_NAME";
    private final static String SPECIALIZATION = "SPECIALIZATION";
    private final static boolean IS_AVAILABLE = true;

    @BeforeAll
    static void setup() {
        entity = createDoctor(FIRST_NAME, LAST_NAME, SPECIALIZATION, IS_AVAILABLE);
        dto = createDoctorDTO(FIRST_NAME, LAST_NAME, SPECIALIZATION, IS_AVAILABLE);
    }

    @Test
    void toDoctor() {
        Doctor doctor = mapper.toDoctor(dto);
        Assertions.assertEquals(FIRST_NAME, doctor.getFirstName());
        Assertions.assertEquals(LAST_NAME, doctor.getLastName());
        Assertions.assertEquals(SPECIALIZATION, doctor.getSpecialization());
        Assertions.assertNotNull(doctor.getSchedule());
        Assertions.assertEquals(IS_AVAILABLE, doctor.isAvailable());
    }

    @Test
    void toDoctorDTO() {
        DoctorDTO doctor = mapper.toDoctorDTO(entity);
        Assertions.assertEquals(FIRST_NAME, doctor.getFirstName());
        Assertions.assertEquals(LAST_NAME, doctor.getLastName());
        Assertions.assertEquals(SPECIALIZATION, doctor.getSpecialization());
        Assertions.assertNotNull(doctor.getSchedule());
        Assertions.assertEquals(IS_AVAILABLE, doctor.isAvailable());
    }
}