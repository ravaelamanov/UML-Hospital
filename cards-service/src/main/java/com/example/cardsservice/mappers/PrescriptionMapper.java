package com.example.cardsservice.mappers;

import com.example.cardsservice.model.Prescription;
import com.example.dtos.cards.PrescriptionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PrescriptionEntryMapper.class})
public interface PrescriptionMapper extends IMapper<Prescription, PrescriptionDTO> {
}
