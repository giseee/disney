package com.alkemychallenge.disney.mapper;

import com.alkemychallenge.disney.builder.GeneroEntityBuilder;
import com.alkemychallenge.disney.dto.GeneroDto;
import com.alkemychallenge.disney.entities.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {
    public GeneroEntity generoDTO2Entity(GeneroEntity dto){
        GeneroEntity entity= new GeneroEntityBuilder()
                .imagen(dto.getImagen())
                .nombre(dto.getNombre())
                .build();
        return entity;
    }
    public GeneroDto generoEntity2DTO(GeneroEntity entity){
        GeneroDto dto= new GeneroDto();
        dto.setIdGenero(entity.getIdGenero());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        return dto;
    }
    public List<GeneroDto> generoEntityList2DTOList(List<GeneroEntity> entities) {
        List<GeneroDto> dtos=new ArrayList<>();
        for(GeneroEntity entity:entities){
            dtos.add(this.generoEntity2DTO(entity));
        }
        return dtos;
    }
}
