package com.alkemychallenge.disney.service.impl;

import com.alkemychallenge.disney.dto.GeneroDto;
import com.alkemychallenge.disney.entities.GeneroEntity;
import com.alkemychallenge.disney.mapper.GeneroMapper;
import com.alkemychallenge.disney.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GeneroService implements com.alkemychallenge.disney.service.GeneroService {
    private GeneroRepository generoRepository;
    private GeneroMapper generoMapper;
    @Autowired
    public GeneroService(GeneroRepository generoRepository, GeneroMapper generoMapper){
        this.generoRepository= generoRepository;
        this.generoMapper=generoMapper;
    }
    public List<GeneroDto> getAllGeneros() {
        List<GeneroEntity> entities= this.generoRepository.findAll();
        List<GeneroDto> result =this.generoMapper.generoEntityList2DTOList(entities);
        return result;
    }
    public GeneroDto save(GeneroDto genero) {
        GeneroDto generoEntity= this.generoMapper.generoDTO2Entity(genero);
        GeneroDto entitySaved= this.generoRepository.save(generoEntity);
        GeneroDto result = this.generoMapper.generoDTO2Entity(entitySaved);
        return result;
    }
}
