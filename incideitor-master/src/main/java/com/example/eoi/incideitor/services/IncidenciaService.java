package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.IncidenciaRepository;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService {

    @Autowired
    IncidenciaRepository incidenciaRepository;

    public Optional<Incidencia> getUserByID(Integer incidenciaId)
    {
        return incidenciaRepository.findById(incidenciaId);
    }

    public List<Incidencia> findAll()
    {
        return incidenciaRepository.findAll();
    }



}
