package com.example.dtos.cards;

import lombok.Data;

@Data
public class DiagnoseDTO {
    private Long id;

    private String description;

    private Type type;

    public enum Type {
        PRIMARY,
        FINAL
    }
}
