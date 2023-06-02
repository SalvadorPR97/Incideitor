package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.abstractcomponents.GenericServiceWithJPA;
import com.example.eoi.incideitor.dtos.AyuntamientoDTO;
import com.example.eoi.incideitor.entities.Ayuntamiento;
import com.example.eoi.incideitor.mapper.AyuntamientoMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AyuntamientoService extends GenericServiceWithJPA<Ayuntamiento, Integer> {

    private final AyuntamientoMapper ayuntamientoMapper;

    //Constructor para permitir que AyuntamientoService utilice un objeto AyuntamientoMapper para realizar mapeos en la BBDD
    public AyuntamientoService(AyuntamientoMapper ayuntamientoMapper){
        this.ayuntamientoMapper = ayuntamientoMapper;
    }


    public AyuntamientoDTO leerDatosAyuntamiento(Integer id){
        AyuntamientoDTO ayuntamientoDTO = new AyuntamientoDTO();
        Optional<Ayuntamiento> ayuntamiento = this.repository.findById(id);
        if(ayuntamiento.isPresent()){
            ayuntamientoDTO = this.ayuntamientoMapper.toDto(ayuntamiento.get());
        }
        return ayuntamientoDTO;
    }

    public AyuntamientoDTO guardarDatosAyuntamiento(AyuntamientoDTO dto){
        Ayuntamiento ayuntamiento = this.ayuntamientoMapper.toEntityUsuario(dto);
        Optional<Ayuntamiento> ayuntamientoBDD = this.repository.findById(dto.getId());
        if(ayuntamientoBDD.isPresent()){
            ayuntamiento.setUsuarios(ayuntamientoBDD.get().getUsuarios());
        }
        //Guardamos el ayuntamiento
        Ayuntamiento ayuntamientoGuardado = update(ayuntamiento);
        return this.ayuntamientoMapper.toDto(ayuntamientoGuardado);
    }









}
