package com.example.doctorsservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Data
public class DoctorDTO {
    @Size(max = 255)
    @JsonProperty("first_name")
    private String firstName;

    @Size(max = 255)
    @JsonProperty("last_name")
    private String lastName;

    @Size(max = 255)
    private String specialization;

    @Valid
    private ScheduleDTO schedule;

    @JsonProperty("is_available")
    private boolean isAvailable;
}
