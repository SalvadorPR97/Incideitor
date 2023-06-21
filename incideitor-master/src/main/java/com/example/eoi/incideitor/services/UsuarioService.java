package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.abstractcomponents.GenericServiceWithJPA;
import com.example.eoi.incideitor.dtos.UsuarioDatosPrivados;
import com.example.eoi.incideitor.dtos.UsuarioDatosPrivadosAyuntamiento;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.mapper.UsuarioMapper;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService extends GenericServiceWithJPA<Usuario, Integer> {


    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
    }

    /**
     * Lee los datos privados de un usuario por su identificador.
     * @param id El identificador del usuario.
     * @return Un objeto UsuarioDatosPrivados que contiene los datos privados del usuario.
     */
    public UsuarioDatosPrivados leerUsuarioPrivado (Integer id){
        UsuarioDatosPrivados usuarioDatosPrivados = new UsuarioDatosPrivados();
        Optional<Usuario> usuario = this.repository.findById(id);
        if (usuario.isPresent()){
            usuarioDatosPrivados =  this.usuarioMapper.toDto(usuario.get());
        }
        return usuarioDatosPrivados;
    }

    /**
     * Guarda los datos privados de un usuario.
     * @param dto Un objeto UsuarioDatosPrivados que contiene los datos privados a guardar.
     * @return Un objeto UsuarioDatosPrivados que representa los datos privados del usuario guardado.
     */
    public  UsuarioDatosPrivados guardarUsuarioDatosPrivados(UsuarioDatosPrivados dto){
        Usuario usuario = this.usuarioMapper.toEntity(dto);
        // Vamos a conseguir los datos que nos faltan
        Optional<Usuario> usuarioBDD = this.repository.findById(dto.getId());
        if (usuarioBDD.isPresent()){
            usuario.setContrasena(usuarioBDD.get().getContrasena());
            usuario.setDni(usuarioBDD.get().getDni());
            usuario.setAyuntamiento(usuarioBDD.get().getAyuntamiento());
            usuario.setReportes(usuarioBDD.get().getReportes());
            usuario.setIncidencias(usuarioBDD.get().getIncidencias());
            usuario.setBorradoLogico(usuarioBDD.get().getBorradoLogico());
            usuario.setDepartamento(usuarioBDD.get().getDepartamento());
            usuario.setExtension(usuarioBDD.get().getExtension());
            usuario.setRol(usuarioBDD.get().getRol());
            usuario.setVotos(usuarioBDD.get().getVotos());
            usuario.setIncidencia(usuarioBDD.get().getIncidencia());
            usuario.setToken(usuarioBDD.get().getToken());
        }
        // Vamos a guardar el usuario
        Usuario usuarioGuardado = update(usuario);
        return this.usuarioMapper.toDto(usuarioGuardado);


    }

    /**
     * Lee los datos de un usuario del ayuntamiento por su identificador.
     * @param id El identificador del usuario.
     * @return Un objeto UsuarioDatosPrivadosAyuntamiento que contiene los datos del usuario del ayuntamiento.
     */
    public UsuarioDatosPrivadosAyuntamiento leerUsuarioAyuntamiento (Integer id){
        UsuarioDatosPrivadosAyuntamiento usuarioDatosPrivadosAyuntamiento = new UsuarioDatosPrivadosAyuntamiento();
        Optional<Usuario> usuario = this.repository.findById(id);
        if (usuario.isPresent()){
            usuarioDatosPrivadosAyuntamiento =  this.usuarioMapper.toDtoAyuntamiento(usuario.get());
        }
        return usuarioDatosPrivadosAyuntamiento;
    }

    /**
     * Guarda los datos de un usuario del ayuntamiento.
     * @param dto Un objeto UsuarioDatosPrivadosAyuntamiento que contiene los datos a guardar.
     * @return Un objeto UsuarioDatosPrivadosAyuntamiento que representa los datos del usuario del ayuntamiento guardado.
     */
    public  UsuarioDatosPrivadosAyuntamiento guardarUsuarioAyuntamiento(UsuarioDatosPrivadosAyuntamiento dto){
        Usuario usuario = this.usuarioMapper.toEntityAyuntamiento(dto);
        // Conseguimos los datos que nos faltan
        Optional<Usuario> usuarioBDD = this.repository.findById(dto.getId());
        if (usuarioBDD.isPresent()){
            usuario.setDepartamento(usuarioBDD.get().getDepartamento());
            usuario.setExtension(usuarioBDD.get().getExtension());
            usuario.setContrasena(usuarioBDD.get().getContrasena());
            usuario.setReportes(usuarioBDD.get().getReportes());
            usuario.setIncidencias(usuarioBDD.get().getIncidencias());
        }
        // Guardamos el usuario
        Usuario usuarioGuardado = update(usuario);
        return this.usuarioMapper.toDtoAyuntamiento(usuarioGuardado);

    }



}
