package com.example.cardsservice.mappers;

public interface IMapper<Entity, DTO> {
    DTO toDTO(Entity entity);
    Entity toEntity(DTO dto);
}
