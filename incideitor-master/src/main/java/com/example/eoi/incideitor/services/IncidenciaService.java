package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.abstractcomponents.GenericServiceWithJPA;
import com.example.eoi.incideitor.dtos.IncidenciaDatos;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.mapper.IncidenciaMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class IncidenciaService extends GenericServiceWithJPA<Incidencia, Long> {

    private final IncidenciaMapper incidenciaMapper;


    public IncidenciaService(IncidenciaMapper incidenciaMapper) {
        this.incidenciaMapper = incidenciaMapper;
    }

    public IncidenciaDatos leerIncidenciaDatos (Long id){
        IncidenciaDatos incidenciaDatos = new IncidenciaDatos();
        Optional<Incidencia> usuario = this.repository.findById(id);
        if (usuario.isPresent()){
            incidenciaDatos =  this.incidenciaMapper.toDtoIncidenciaDatos(usuario.get());
        }
        return incidenciaDatos;
    }

    public  IncidenciaDatos guardarIncidenciaDatos(IncidenciaDatos dto){
        Incidencia incidencia = this.incidenciaMapper.toEntityIncidenciaDatos(dto);
        // Vamos a conseguir los datos que nos faltan
        Optional<Incidencia> incidenciBDD = this.repository.findById(dto.getId());
        if (incidenciBDD.isPresent()){
            incidencia.setFecha(incidenciBDD.get().getFecha());
            incidencia.setUsuario(incidenciBDD.get().getUsuario());
            incidencia.setAyuntamiento(incidenciBDD.get().getAyuntamiento());
            incidencia.setHistoricos(incidenciBDD.get().getHistoricos());
            incidencia.setDireccion(incidenciBDD.get().getDireccion());
            incidencia.setFotos(incidenciBDD.get().getFotos());
            incidencia.setNotificaciones(incidenciBDD.get().getNotificaciones());
            incidencia.setParametroIncidencia(incidenciBDD.get().getParametroIncidencia());
            incidencia.setReportes(incidenciBDD.orElseThrow().getReportes());
            incidencia.setVotos(incidenciBDD.get().getVotos());
            incidencia.setBorradoLogico(incidenciBDD.get().getBorradoLogico());
            incidencia.setIdGestor(incidenciBDD.get().getIdGestor());
            incidencia.setTipoIncidencia(incidenciBDD.get().getTipoIncidencia());
        }
        // Vamos a guardar el usuario
        Incidencia incidenciaGuardada = update(incidencia);
        return this.incidenciaMapper.toDtoIncidenciaDatos(incidenciaGuardada);
    }
}