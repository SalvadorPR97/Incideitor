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

    public UsuarioService(UsuarioMapper usuarioMapper,
                          UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDatosPrivados leerUsuarioPrivado (Integer id){
        UsuarioDatosPrivados usuarioDatosPrivados = new UsuarioDatosPrivados();
        Optional<Usuario> usuario = this.repository.findById(id);
        if (usuario.isPresent()){
            usuarioDatosPrivados =  this.usuarioMapper.toDto(usuario.get());
        }
        return usuarioDatosPrivados;
    }
    public  UsuarioDatosPrivados guardarUsuarioDatosPrivados(UsuarioDatosPrivados dto){
        Usuario usuario = this.usuarioMapper.toEntity(dto);
        // Vamos a conseguir los datos que nos faltan
        Optional<Usuario> usuarioBDD = this.repository.findById(dto.getId());
        if (usuarioBDD.isPresent()){
            usuario.setContrasena(usuarioBDD.get().getContrasena());
            usuario.setAyuntamiento(usuarioBDD.get().getAyuntamiento());
            usuario.setReportes(usuarioBDD.get().getReportes());
            usuario.setIncidencias(usuarioBDD.get().getIncidencias());
            usuario.setBorradoLogico(usuarioBDD.get().getBorradoLogico());
            usuario.setDepartamento(usuarioBDD.get().getDepartamento());
            usuario.setExtension(usuarioBDD.get().getExtension());
            usuario.setRoles(usuarioBDD.get().getRoles());
            usuario.setVotos(usuarioBDD.get().getVotos());
            usuario.setIncidencia(usuarioBDD.get().getIncidencia());
        }
        // Vamos a guardar el usuario
        Usuario usuarioGuardado = update(usuario);
        return this.usuarioMapper.toDto(usuarioGuardado);


    }

    public UsuarioDatosPrivadosAyuntamiento leerUsuarioAyuntamiento (Integer id){
        UsuarioDatosPrivadosAyuntamiento usuarioDatosPrivadosAyuntamiento = new UsuarioDatosPrivadosAyuntamiento();
        Optional<Usuario> usuario = this.repository.findById(id);
        if (usuario.isPresent()){
            usuarioDatosPrivadosAyuntamiento =  this.usuarioMapper.toDtoAyuntamiento(usuario.get());
        }
        return usuarioDatosPrivadosAyuntamiento;
    }

    public  UsuarioDatosPrivadosAyuntamiento guardarUsuarioAyuntamiento(UsuarioDatosPrivadosAyuntamiento dto){
        Usuario usuario = this.usuarioMapper.toEntityAyuntamiento(dto);
        // Vamos a conseguir los datos que nos faltan
        Optional<Usuario> usuarioBDD = this.repository.findById(dto.getId());
        if (usuarioBDD.isPresent()){
            usuario.setDepartamento(usuarioBDD.get().getDepartamento());
            usuario.setExtension(usuarioBDD.get().getExtension());
            usuario.setContrasena(usuarioBDD.get().getContrasena());
            usuario.setReportes(usuarioBDD.get().getReportes());
            usuario.setIncidencias(usuarioBDD.get().getIncidencias());
        }
        // Vamos a guardar el usuario
        Usuario usuarioGuardado = update(usuario);
        return this.usuarioMapper.toDtoAyuntamiento(usuarioGuardado);


    }
}
