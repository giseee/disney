package com.alkemychallenge.disney.dto;

import com.alkemychallenge.disney.entities.GeneroEntity;
import com.alkemychallenge.disney.entities.PersonajeEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DetallePeliculaDto {
    private String imagen;
    private String titulo;
    @DateTimeFormat(pattern ="yyyy/mm/dd")
    private LocalTime fecha;
    private Integer calificacion;//1 a 5
    private GeneroEntity genero;
    private List<PersonajeEntity> personajes= new ArrayList<>();
}
