package com.example.appointmentsservice.mappers;

public interface IMapper<Entity, Dto> {
    Entity toEntity(Dto dto);
    Dto toDTO(Entity entity);
}
