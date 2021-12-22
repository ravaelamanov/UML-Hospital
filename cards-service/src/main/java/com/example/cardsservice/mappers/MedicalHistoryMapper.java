package com.example.cardsservice.mappers;

import com.example.cardsservice.model.MedicalHistory;
import com.example.dtos.cards.MedicalHistoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DiagnoseMapper.class, SickLeaveMapper.class, PrescriptionMapper.class})
public interface MedicalHistoryMapper extends IMapper<MedicalHistory, MedicalHistoryDTO>{
}
