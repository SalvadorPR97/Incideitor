package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Incidencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {

    @Query("SELECT i FROM Incidencia i ORDER BY i.id DESC ")
    List<Incidencia> obtenerUltimaIncidencia();

    @Override
    Page<Incidencia> findAll(Pageable pageable);
}