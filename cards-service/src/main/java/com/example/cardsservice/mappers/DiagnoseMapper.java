package com.example.cardsservice.mappers;

import com.example.cardsservice.model.Diagnose;
import com.example.dtos.cards.DiagnoseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiagnoseMapper extends IMapper<Diagnose, DiagnoseDTO> {

}
