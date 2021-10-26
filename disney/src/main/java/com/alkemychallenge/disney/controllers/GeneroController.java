package com.alkemychallenge.disney.controllers;

import com.alkemychallenge.disney.dto.GeneroDto;
import com.alkemychallenge.disney.entities.GeneroEntity;
import com.alkemychallenge.disney.service.impl.GeneroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genero")
@CrossOrigin("*")
public class GeneroController {
    private GeneroServiceImpl generoService;
    @Autowired
    public GeneroController(GeneroServiceImpl generoService){
        this.generoService=generoService; }
    @GetMapping
    public ResponseEntity<List<GeneroDto>> getAll(){
        List<GeneroDto>generos= this.generoService.findAll();
        return ResponseEntity.ok().body(generos);
    }
    @PostMapping
    public ResponseEntity<GeneroDto> save(@RequestBody GeneroEntity genero ){
        GeneroDto result =this.generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);}
}
