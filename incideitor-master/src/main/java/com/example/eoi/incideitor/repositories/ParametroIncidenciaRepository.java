package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.ParametroIncidencia;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParametroIncidenciaRepository extends JpaRepository<ParametroIncidencia, Integer> {


}