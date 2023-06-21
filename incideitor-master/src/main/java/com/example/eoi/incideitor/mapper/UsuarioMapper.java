package com.example.eoi.incideitor.mapper;


import com.example.eoi.incideitor.dtos.UsuarioDatosPrivados;
import com.example.eoi.incideitor.dtos.UsuarioDatosPrivadosAyuntamiento;
import com.example.eoi.incideitor.dtos.UsuarioMiPerfil;
import com.example.eoi.incideitor.entities.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper {
    /**
     * Convierte una entidad Usuario a un DTO UsuarioDatosPrivados.
     *
     * @param entidad Entidad Usuario
     * @return DTO UsuarioDatosPrivados
     */
    public UsuarioDatosPrivados toDto(Usuario entidad){
        final UsuarioDatosPrivados dto = new UsuarioDatosPrivados();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    /**
     * Convierte un DTO UsuarioDatosPrivados a una entidad Usuario.
     *
     * @param dto DTO UsuarioDatosPrivados
     * @return Entidad Usuario
     */
    public Usuario toEntity (UsuarioDatosPrivados dto) {
        final Usuario entity = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entity);
        return entity;
    }

    /**
     * Convierte una entidad Usuario a un DTO UsuarioDatosPrivadosAyuntamiento.
     *
     * @param entidad Entidad Usuario
     * @return DTO UsuarioDatosPrivadosAyuntamiento
     */
    public UsuarioDatosPrivadosAyuntamiento toDtoAyuntamiento(Usuario entidad){
        final UsuarioDatosPrivadosAyuntamiento dto = new UsuarioDatosPrivadosAyuntamiento();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    /**
     * Convierte un DTO UsuarioDatosPrivadosAyuntamiento a una entidad Usuario.
     *
     * @param dto DTO UsuarioDatosPrivadosAyuntamiento
     * @return Entidad Usuario
     */
    public Usuario toEntityAyuntamiento (UsuarioDatosPrivadosAyuntamiento dto) {
        final Usuario entity = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entity);
        return entity;
    }

    /**
     * Convierte una entidad Usuario a un DTO UsuarioMiPerfil.
     *
     * @param entidad Entidad Usuario
     * @return DTO UsuarioMiPerfil
     */
    public UsuarioMiPerfil toDtoMiPerfil(Usuario entidad){
        final UsuarioMiPerfil dto = new UsuarioMiPerfil();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    public UsuarioMapper() {
    }
}
