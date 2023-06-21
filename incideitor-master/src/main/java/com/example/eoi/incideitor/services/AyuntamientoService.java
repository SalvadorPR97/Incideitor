package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.abstractcomponents.GenericServiceWithJPA;
import com.example.eoi.incideitor.dtos.AyuntamientoDTO;
import com.example.eoi.incideitor.entities.Ayuntamiento;
import com.example.eoi.incideitor.mapper.AyuntamientoMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Clase de servicio que proporciona métodos para leer y guardar datos de un objeto Ayuntamiento.
 * Extiende la clase GenericServiceWithJPA.
 */
@Service
public class AyuntamientoService extends GenericServiceWithJPA<Ayuntamiento, Integer> {

    private final AyuntamientoMapper ayuntamientoMapper;

    /**
     * Constructor de AyuntamientoService que recibe un objeto AyuntamientoMapper para realizar mapeos en la base de datos.
     *
     * @param ayuntamientoMapper Objeto AyuntamientoMapper utilizado para los mapeos.
     */
    public AyuntamientoService(AyuntamientoMapper ayuntamientoMapper) {
        this.ayuntamientoMapper = ayuntamientoMapper;
    }

    /**
     * Lee los datos de un Ayuntamiento por su identificador.
     *
     * @param id Identificador del Ayuntamiento.
     * @return DTO que representa los datos del Ayuntamiento.
     */
    public AyuntamientoDTO leerDatosAyuntamiento(Integer id) {
        AyuntamientoDTO ayuntamientoDTO = new AyuntamientoDTO();
        Optional<Ayuntamiento> ayuntamiento = this.repository.findById(id);
        if (ayuntamiento.isPresent()) {
            ayuntamientoDTO = this.ayuntamientoMapper.toDto(ayuntamiento.get());
        }
        return ayuntamientoDTO;
    }

    /**
     * Guarda los datos de un Ayuntamiento.
     *
     * @param dto DTO que contiene los datos del Ayuntamiento a guardar.
     * @return DTO que representa los datos del Ayuntamiento guardado.
     */
    public AyuntamientoDTO guardarDatosAyuntamiento(AyuntamientoDTO dto) {
        Ayuntamiento ayuntamiento = this.ayuntamientoMapper.toEntity(dto);
        Optional<Ayuntamiento> ayuntamientoBDD = this.repository.findById(dto.getId());
        if (ayuntamientoBDD.isPresent()) {
            ayuntamiento.setFotoCabecera(ayuntamientoBDD.get().getFotoCabecera());
            ayuntamiento.setFotoLogin(ayuntamientoBDD.get().getFotoLogin());
            ayuntamiento.setFoto3(ayuntamientoBDD.get().getFoto3());
            ayuntamiento.setFoto4(ayuntamientoBDD.get().getFoto4());
            ayuntamiento.setUsuarios(ayuntamientoBDD.get().getUsuarios());
        }
        Ayuntamiento ayuntamientoGuardado = update(ayuntamiento);
        return this.ayuntamientoMapper.toDto(ayuntamientoGuardado);
    }
}

