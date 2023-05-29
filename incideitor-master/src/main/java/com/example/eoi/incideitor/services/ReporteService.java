package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.entities.Reporte;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.ReporteRepository;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {

    @Autowired
    ReporteRepository reporteRepository;

    public Optional<Reporte> getUserByID(Integer reporteId)
    {
        return reporteRepository.findById(reporteId);
    }

        public List<Reporte> findAll()
    {
        return reporteRepository.findAll();
    }



}
