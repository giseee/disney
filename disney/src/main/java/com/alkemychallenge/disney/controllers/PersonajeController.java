package com.alkemychallenge.disney.controllers;

import com.alkemychallenge.disney.entities.PersonajeEntity;
import com.alkemychallenge.disney.service.impl.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("personaje")
@CrossOrigin("*")
public class PersonajeController {
    private PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }
//cambiar por el dto
    @RequestMapping("character")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente mas tarde\"}");
        }
    }
    @RequestMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable  Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.findById(id));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente mas tarde\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody PersonajeEntity personaje){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.save(personaje));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente mas tarde\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable  Long id, PersonajeEntity personajeEntity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.update(id, personajeEntity));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente mas tarde\"}");
        }
    }
    @DeleteMapping("{/id}")
    public ResponseEntity<?> delete(@PathVariable  Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.delete(id));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{\"error\":\"error por favor intente mas tarde\"}");
        }

}
}
