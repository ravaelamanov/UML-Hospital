package com.example.doctorsservice.mappers;

import com.example.doctorsservice.model.Doctor;
import com.example.doctorsservice.model.Schedule;
import com.example.doctorsservice.model.WorkingDay;
import com.example.dtos.doctors.DoctorDTO;
import com.example.dtos.doctors.ScheduleDTO;
import com.example.dtos.doctors.WorkingDayDTO;

import java.time.LocalTime;
import java.util.ArrayList;

public class AbstractMapperTest {
    protected static WorkingDay createWorkingDay(Long id, int day, LocalTime start, LocalTime finish) {
        WorkingDay entity = new WorkingDay();
        entity.setId(id);
        entity.setDay(day);
        entity.setStart(start);
        entity.setFinish(finish);
        return entity;
    }

    protected static WorkingDayDTO createWorkingDayDTO(int day, LocalTime start, LocalTime finish) {
        WorkingDayDTO dto = new WorkingDayDTO();
        dto.setDay(day);
        dto.setStart(start);
        dto.setFinish(finish);
        return dto;
    }

    protected static Schedule createSchedule(int n) {
        var workingDays = new ArrayList<WorkingDay>();
        var start = LocalTime.parse("08:00");
        var finish = LocalTime.parse("17:00");
        for (int i = 0; i < n; i++) {
            workingDays.add(createWorkingDay((long) i, i, start, finish));
        }
        var schedule = new Schedule();
        schedule.setWorkingDays(workingDays);
        return schedule;
    }

    protected static ScheduleDTO createScheduleDTO(int n) {
        var workingDays = new ArrayList<WorkingDayDTO>();
        var start = LocalTime.parse("08:00");
        var finish = LocalTime.parse("17:00");
        for (int i = 0; i < n; i++) {
            workingDays.add(createWorkingDayDTO(i, start, finish));
        }
        var schedule = new ScheduleDTO();
        schedule.setWorkingDays(workingDays);
        return schedule;
    }

    protected static Doctor createDoctor(String firstName, String lastName, String specialization, boolean isAvaliable) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setSpecialization(specialization);
        doctor.setSchedule(createSchedule(5));
        doctor.setAvailable(isAvaliable);
        return doctor;
    }

    protected static DoctorDTO createDoctorDTO(String firstName, String lastName, String specialization, boolean isAvaliable) {
        DoctorDTO doctor = new DoctorDTO();
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setSpecialization(specialization);
        doctor.setSchedule(createScheduleDTO(5));
        doctor.setAvailable(isAvaliable);
        return doctor;
    }
}
