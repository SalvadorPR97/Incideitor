package com.example.eoi.incideitor.mapper;

import com.example.eoi.incideitor.dtos.IncidenciaDatos;
import com.example.eoi.incideitor.dtos.IncidenciaUsuarioDTO;
import com.example.eoi.incideitor.entities.Incidencia;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class IncidenciaMapper {

    /**
     * Convierte una entidad Incidencia a un DTO IncidenciaUsuarioDTO.
     *
     * @param entidad Entidad Incidencia
     * @return DTO IncidenciaUsuarioDTO
     */
    public IncidenciaUsuarioDTO toDtoUsuario(Incidencia entidad){
        final IncidenciaUsuarioDTO dto = new IncidenciaUsuarioDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    /**
     * Convierte un DTO IncidenciaUsuarioDTO a una entidad Incidencia.
     *
     * @param dto DTO IncidenciaUsuarioDTO
     * @return Entidad Incidencia
     */
    public Incidencia toEntityIncidenciaUsuario(IncidenciaUsuarioDTO dto){
        final Incidencia entity = new Incidencia();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entity);
        return entity;
    }

    /**
     * Convierte una entidad Incidencia a un DTO IncidenciaDatos.
     *
     * @param entidad Entidad Incidencia
     * @return DTO IncidenciaDatos
     */
    public IncidenciaDatos toDtoIncidenciaDatos(Incidencia entidad){
        final IncidenciaDatos dto = new IncidenciaDatos();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    /**
     * Convierte un DTO IncidenciaDatos a una entidad Incidencia.
     *
     * @param dto DTO IncidenciaDatos
     * @return Entidad Incidencia
     */
    public Incidencia toEntityIncidenciaDatos(IncidenciaDatos dto){
        final Incidencia entity = new Incidencia();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entity);
        return entity;
    }

    /**
     * Constructor por defecto de la clase IncidenciaMapper.
     */
    public IncidenciaMapper() {
    }
}
