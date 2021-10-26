package com.alkemychallenge.disney.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_pelicula")
    private Long idPelicula;
    private String imagen;
    private String titulo;
    @Column(name= "fecha_de_creacion")
    @DateTimeFormat(pattern ="yyyy/mm/dd")
    private LocalTime fecha;
    private Integer calificacion;//1 a 5
    @ManyToOne
    @JoinColumn(name="id_genero", insertable= false, updatable = false)
    private GeneroEntity genero;
    @Column (name ="id_genero", nullable = false)
    private Long generoId;
    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name= "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_personaje"))
    private List<PersonajeEntity> personajes= new ArrayList<>();
public void addPersonaje()
    }

}
