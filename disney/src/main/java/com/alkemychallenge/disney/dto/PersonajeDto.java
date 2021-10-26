package com.alkemychallenge.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDto {
    private Long id;
    private String nombre;
    private String imagen;
}
