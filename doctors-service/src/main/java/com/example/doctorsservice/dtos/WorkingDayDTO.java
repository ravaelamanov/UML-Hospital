package com.example.doctorsservice.dtos;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalTime;

@Data
public class WorkingDayDTO {
    @Min(0)
    @Max(6)
    private int day;

    private LocalTime start;

    private LocalTime finish;
}
