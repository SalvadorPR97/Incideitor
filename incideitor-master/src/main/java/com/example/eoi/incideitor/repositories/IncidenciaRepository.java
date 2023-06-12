package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {

    @Query("SELECT i FROM Incidencia i ORDER BY i.fecha DESC")
    List<Incidencia> obtenerUltimaIncidencia();
}