package com.alkemychallenge.disney.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_personaje")
    private Long idPersonaje;
    private String imagen;
    private String nombre;
    private Integer edad;
    private float peso;
    private String Historia;
    @ManyToMany(mappedBy = "personajes", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PeliculaEntity> peliculas= new HashSet<>();

}
