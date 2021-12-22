package com.example.dtos.doctors;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;

@Data
public class DoctorWithIdDTO {

    private Long id;

    @Valid
    @JsonProperty("doctor_details")
    private DoctorDTO doctorDetails;
}
