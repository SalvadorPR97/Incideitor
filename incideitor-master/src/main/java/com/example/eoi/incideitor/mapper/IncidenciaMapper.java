package com.example.eoi.incideitor.mapper;

import com.example.eoi.incideitor.dtos.IncidenciaDatos;
import com.example.eoi.incideitor.dtos.IncidenciaUsuarioDTO;
import com.example.eoi.incideitor.entities.Incidencia;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class IncidenciaMapper {

    //Conversiones de entidad a DTO y de DTO a Entidad

    public IncidenciaUsuarioDTO toDtoUsuario(Incidencia entidad){
        final IncidenciaUsuarioDTO dto = new IncidenciaUsuarioDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    public Incidencia toEntityIncidenciaUsuario(IncidenciaUsuarioDTO dto){
        final Incidencia entity = new Incidencia();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entity);
        return entity;
    }

    public IncidenciaDatos toDtoIncidenciaDatos(Incidencia entidad){
        final IncidenciaDatos dto = new IncidenciaDatos();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    public Incidencia toEntityIncidenciaDatos(IncidenciaDatos dto){
        final Incidencia entity = new Incidencia();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entity);
        return entity;
    }


    public IncidenciaMapper() {
    }
}
