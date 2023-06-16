package com.example.eoi.incideitor.mapper;


import com.example.eoi.incideitor.dtos.UsuarioDatosPrivados;
import com.example.eoi.incideitor.dtos.UsuarioDatosPrivadosAyuntamiento;
import com.example.eoi.incideitor.dtos.UsuarioMiPerfil;
import com.example.eoi.incideitor.entities.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper {
    //Convertir de entidad a dto

    public UsuarioDatosPrivados toDto(Usuario entidad){
        final UsuarioDatosPrivados dto = new UsuarioDatosPrivados();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    public Usuario toEntity (UsuarioDatosPrivados dto) {
        final Usuario entity = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entity);
        return entity;
    }

    public UsuarioDatosPrivadosAyuntamiento toDtoAyuntamiento(Usuario entidad){
        final UsuarioDatosPrivadosAyuntamiento dto = new UsuarioDatosPrivadosAyuntamiento();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }

    public Usuario toEntityAyuntamiento (UsuarioDatosPrivadosAyuntamiento dto) {
        final Usuario entity = new Usuario();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entity);
        return entity;
    }
    public UsuarioMiPerfil toDtoMiPerfil(Usuario entidad){
        final UsuarioMiPerfil dto = new UsuarioMiPerfil();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    public UsuarioMapper() {
    }
}
