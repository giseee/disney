package com.alkemychallenge.disney.service;

import com.alkemychallenge.disney.dto.GeneroDto;

import java.util.List;

public interface GeneroService {
    List<GeneroDto> getAllGeneros();
    GeneroDto save(GeneroDto genero);
}
