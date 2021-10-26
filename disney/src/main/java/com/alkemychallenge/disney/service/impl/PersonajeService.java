package com.alkemychallenge.disney.service.impl;

import com.alkemychallenge.disney.entities.PersonajeEntity;
import com.alkemychallenge.disney.repository.PersonajeRepository;
import com.alkemychallenge.disney.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService implements BaseService<PersonajeEntity> {
    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    @Transactional
    public List findAll() throws Exception {
        try {
            List<PersonajeEntity> entities= personajeRepository.findAll();
            return entities;

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public PersonajeEntity findById(Long id) throws Exception {
        try {
            Optional<PersonajeEntity> personajeEntity=personajeRepository.findById(id);
            return  personajeEntity.get();

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public PersonajeEntity save(PersonajeEntity entity) throws Exception {
        try {
            entity = personajeRepository.save(entity);
            return entity;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PersonajeEntity update(Long id, PersonajeEntity entity) throws Exception {
        try {
            Optional<PersonajeEntity> optionalPersonajeEntity= personajeRepository.findById(id);
            PersonajeEntity personaje= optionalPersonajeEntity.get();
            personaje= personajeRepository.save(personaje);
            return personaje;


        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try { if (personajeRepository.existsById(id)){
                   personajeRepository.deleteById(id);
                   return true;
        }
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }

    }
   }
