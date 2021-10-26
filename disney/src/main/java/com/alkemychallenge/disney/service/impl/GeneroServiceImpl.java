package com.alkemychallenge.disney.service.impl;

import com.alkemychallenge.disney.dto.GeneroDto;
import com.alkemychallenge.disney.entities.GeneroEntity;
import com.alkemychallenge.disney.repository.GeneroRepository;
import com.alkemychallenge.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService<GeneroDto> {
    @Autowired
    private GeneroRepository generoRepository;

    @Override
    @Transactional
    public List<GeneroEntity> findAll() throws Exception {
        try {
            List<GeneroEntity> entities = generoRepository.findAll();
            return entities;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Transactional
    public GeneroEntity getByIdGenero(Long id) throws Exception {
        try {
            List<GeneroEntity> genero=null;
            List<GeneroEntity> genero = generoRepository.findAllById(id);
            return genero;

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }