package com.alkemychallenge.disney.controllers;

import com.alkemychallenge.disney.dto.GeneroDto;
import com.alkemychallenge.disney.service.impl.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genero")
@CrossOrigin("*")
public class GeneroController {
    private GeneroService generoService;
    @Autowired
    public GeneroController(GeneroService generoService){
        this.generoService=generoService; }
    @GetMapping
    public ResponseEntity<List<GeneroDto>> getAll(){
        List<GeneroDto>generos= this.generoService.getAllGeneros();
        return ResponseEntity.ok().body(generos);
    }
    @PostMapping
    public ResponseEntity<GeneroDto> save(@RequestBody GeneroDto genero ){
        GeneroDto result =this.generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);}
}
