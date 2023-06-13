package com.example.eoi.incideitor.mapper;

import com.example.eoi.incideitor.dtos.AyuntamientoDTO;
import com.example.eoi.incideitor.entities.Ayuntamiento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class AyuntamientoMapper {

    //CONVERTIMOS LA ENTIDAD A DTO
    public AyuntamientoDTO toDto(Ayuntamiento entidad){
        final AyuntamientoDTO dto = new AyuntamientoDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    public Ayuntamiento toEntity(AyuntamientoDTO dto){
        final Ayuntamiento entity = new Ayuntamiento();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
        return entity;
    }

    public AyuntamientoMapper(){

    }

}
