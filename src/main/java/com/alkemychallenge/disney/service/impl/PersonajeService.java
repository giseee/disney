package com.alkemychallenge.disney.service.impl;

import com.alkemychallenge.disney.repository.PersonajeRepository;
import com.alkemychallenge.disney.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService implements BaseService {
    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List findAll() throws Exception {
        return null;
    }

    @Override
    public Object findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Object save(Object entity) throws Exception {
        return null;
    }

    @Override
    public Object update(Long id, Object entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }
}
