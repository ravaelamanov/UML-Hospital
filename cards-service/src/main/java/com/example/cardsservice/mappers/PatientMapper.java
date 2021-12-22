package com.example.cardsservice.mappers;

import com.example.cardsservice.model.Patient;
import com.example.dtos.cards.PatientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper extends IMapper<Patient, PatientDTO>{
}
