package com.example.eoi.incideitor.mapper;

import com.example.eoi.incideitor.dtos.AyuntamientoDTO;
import com.example.eoi.incideitor.entities.Ayuntamiento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class AyuntamientoMapper {

    /**
     * Convierte una entidad Ayuntamiento a un DTO AyuntamientoDTO.
     *
     * @param entidad Entidad Ayuntamiento
     * @return DTO AyuntamientoDTO
     */
    public AyuntamientoDTO toDto(Ayuntamiento entidad){
        final AyuntamientoDTO dto = new AyuntamientoDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    /**
     * Convierte un DTO AyuntamientoDTO a una entidad Ayuntamiento.
     *
     * @param dto DTO AyuntamientoDTO
     * @return Entidad Ayuntamiento
     */
    public Ayuntamiento toEntity(AyuntamientoDTO dto){
        final Ayuntamiento entity = new Ayuntamiento();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
        return entity;
    }

    /**
     * Constructor por defecto de la clase AyuntamientoMapper.
     */
    public AyuntamientoMapper(){

    }

}
