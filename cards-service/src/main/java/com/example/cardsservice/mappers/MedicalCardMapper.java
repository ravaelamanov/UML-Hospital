package com.example.cardsservice.mappers;

import com.example.cardsservice.model.MedicalCard;
import com.example.dtos.cards.MedicalCardDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PatientMapper.class, MedicalHistoryMapper.class})
public interface MedicalCardMapper extends IMapper<MedicalCard, MedicalCardDTO>{
}
