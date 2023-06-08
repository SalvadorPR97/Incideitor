package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
}