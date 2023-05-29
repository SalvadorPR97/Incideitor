package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.entities.Ayuntamiento;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.AyuntamientoRepository;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AyuntamientoService {

    @Autowired
    AyuntamientoRepository ayuntamientoRepository;

    public Optional<Ayuntamiento> getUserByID(Integer ayuntamientoId)
    {
        return ayuntamientoRepository.findById(ayuntamientoId);
    }

    public List<Ayuntamiento> findAll()
    {
        return ayuntamientoRepository.findAll();
    }



}
