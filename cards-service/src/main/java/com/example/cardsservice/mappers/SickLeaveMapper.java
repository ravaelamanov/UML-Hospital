package com.example.cardsservice.mappers;

import com.example.cardsservice.model.SickLeave;
import com.example.dtos.cards.SickLeaveDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SickLeaveMapper extends IMapper<SickLeave, SickLeaveDTO> {
}
