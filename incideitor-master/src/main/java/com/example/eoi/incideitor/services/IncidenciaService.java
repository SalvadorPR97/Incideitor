package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.abstractcomponents.GenericServiceWithJPA;
import com.example.eoi.incideitor.dtos.IncidenciaDatos;
import com.example.eoi.incideitor.dtos.IncidenciaUsuarioDTO;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.mapper.IncidenciaMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class IncidenciaService extends GenericServiceWithJPA<Incidencia, Long> {



}