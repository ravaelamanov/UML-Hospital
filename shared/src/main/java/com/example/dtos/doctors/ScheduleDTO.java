package com.example.dtos.doctors;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class ScheduleDTO {
    @Valid
    @JsonProperty("working_days")
    private List<WorkingDayDTO> workingDays;
}
