package com.example.cardsservice.mappers;

import com.example.cardsservice.model.PrescriptionEntry;
import com.example.dtos.cards.PrescriptionEntryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrescriptionEntryMapper extends IMapper<PrescriptionEntry, PrescriptionEntryDTO> {
}
