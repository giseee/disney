package com.alkemychallenge.disney.controllers;

import com.alkemychallenge.disney.entities.PeliculaEntity;
import com.alkemychallenge.disney.service.impl.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pelicula")
@CrossOrigin("*")
public class PeliculaController {
    private PeliculaService peliculaService;
    @Autowired
    public PeliculaController(PeliculaService peliculaService){
        this.peliculaService= peliculaService;
    }
    @RequestMapping("/movies")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliculaService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente mas tarde\"}");
        }
    }

}
