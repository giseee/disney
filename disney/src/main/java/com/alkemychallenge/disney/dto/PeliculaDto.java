package com.alkemychallenge.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PeliculaDto {
    private String imagen;
    private String titulo;
    @DateTimeFormat(pattern ="yyyy/mm/dd")
    private LocalTime fecha;

}
