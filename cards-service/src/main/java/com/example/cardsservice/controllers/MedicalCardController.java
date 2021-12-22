package com.example.cardsservice.controllers;

import com.example.cardsservice.mappers.MedicalCardMapper;
import com.example.cardsservice.services.MedicalCardService;
import com.example.dtos.cards.MedicalCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class MedicalCardController {

    private final MedicalCardMapper mapper;
    private final MedicalCardService service;

    @Autowired
    public MedicalCardController(MedicalCardMapper mapper, MedicalCardService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/{id}")
    public MedicalCardDTO getCard(@PathVariable Long id) {
        return mapper.toDTO(service.findCardById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicalCardDTO createCard(@RequestBody MedicalCardDTO medicalCardDTO) {
        return mapper.toDTO(service.createCard(mapper.toEntity(medicalCardDTO)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCard(@RequestBody MedicalCardDTO dto) {
        service.updateCard(mapper.toEntity(dto));
    }
}
