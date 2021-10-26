package com.alkemychallenge.disney.service.impl;

import com.alkemychallenge.disney.dto.PeliculaDto;
import com.alkemychallenge.disney.entities.PeliculaEntity;
import com.alkemychallenge.disney.mapper.PeliculaMapper;
import com.alkemychallenge.disney.repository.PeliculaRepository;
import com.alkemychallenge.disney.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService implements BaseService<PeliculaDto> {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PeliculaMapper peliculaMapper;

    @Override
    @Transactional
    public List<PeliculaDto> getAllPeliculas() throws Exception {
        try {
            List<PeliculaEntity>entities=peliculaRepository.findAll(); //arreglar
            List<PeliculaDto> peliculaDtos = this.peliculasMapper.metododemapeo(entities);
            return peliculaDtos;
        }catch (Exception e) {
            throw new Exception(e.getMessage());

        }

    }

    @Override
    @Transactional
    public PeliculaDto findById(Long id) throws Exception {
        try {
            Optional<PeliculaDto> optionalPeliculaEntity= peliculaRepository.findById(id);
            return optionalPeliculaEntity.get();

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public PeliculaDto save(PeliculaDto peliculaDto) throws Exception {
        try {
            PeliculaEntity entity = this.peliculaMapper.metodo(peliculaDto);//arreglar
            PeliculaEntity entitySaved= this.peliculaRepository.save(entity);
            PeliculaDto peliculaDto= this.peliculaMapper.metodo(peliculaDto);//arreglar
            return peliculaDto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public PeliculaDto update(Long id,PeliculaDto entity) throws Exception {
        try {
            Optional<PeliculaDto> optionalPeliculaEntity= peliculaRepository.findById(id);
            PeliculaDto pelicula=optionalPeliculaEntity.get();
            pelicula= peliculaRepository.save(pelicula);
            return pelicula;

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (peliculaRepository.existsById(id)) {
                peliculaRepository.deleteById(id);
                return true;}
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
