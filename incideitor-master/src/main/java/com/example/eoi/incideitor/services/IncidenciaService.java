package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.abstractcomponents.GenericServiceWithJPA;
import com.example.eoi.incideitor.dtos.IncidenciaDatos;
import com.example.eoi.incideitor.dtos.IncidenciaUsuarioDTO;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.mapper.IncidenciaMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class IncidenciaService extends GenericServiceWithJPA<Incidencia, Integer> {

    private final IncidenciaMapper incidenciaMapper;

    public IncidenciaService(IncidenciaMapper incidenciaMapper) {
        this.incidenciaMapper = incidenciaMapper;
    }

    public IncidenciaUsuarioDTO leerIncidenciaUsuario(Integer id){
        IncidenciaUsuarioDTO incidenciaUsuarioDTO = new IncidenciaUsuarioDTO();
        Optional<Incidencia> incidencia = this.repository.findById(id);
        if (incidencia.isPresent()){
            incidenciaUsuarioDTO = this.incidenciaMapper.toDtoUsuario(incidencia.get());
        }
        return incidenciaUsuarioDTO;
    }

    public IncidenciaUsuarioDTO guardarIncidenciaUsuario(IncidenciaUsuarioDTO dto){
        Incidencia incidencia = this.incidenciaMapper.toEntityIncidenciaUsuario(dto);
        Optional<Incidencia> incidenciaBDD = this.repository.findById(dto.getId());
        if (incidenciaBDD.isPresent()){
            incidencia.setAyuntamiento(incidenciaBDD.get().getAyuntamiento());
        }
        Incidencia incidenciaGuardada = update(incidencia);
        return this.incidenciaMapper.toDtoUsuario(incidenciaGuardada);
    }

    public IncidenciaDatos leerIncidenciaDatos(Integer id){
        IncidenciaDatos incidenciaDatos = new IncidenciaDatos();
        Optional<Incidencia> incidencia = this.repository.findById(id);
        if (incidencia.isPresent()){
            incidenciaDatos = this.incidenciaMapper.toDtoIncidenciaDatos(incidencia.get());
        }
        return incidenciaDatos;
    }

    public IncidenciaDatos guardarIncidenciaDatos(IncidenciaDatos dto){
        Incidencia incidencia = this.incidenciaMapper.toEntityIncidenciaDatos(dto);
        Incidencia incidenciaGuardada = update(incidencia);
        return this.incidenciaMapper.toDtoIncidenciaDatos(incidenciaGuardada);
    }


}