package com.alkemychallenge.disney.dto;

import com.alkemychallenge.disney.entities.PeliculaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetallePersonaje {

    private String imagen;
    private String nombre;
    private Integer edad;
    private float peso;
    private String Historia;
    private List<PeliculaEntity> peliculas= new ArrayList<>();

}
