package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
    List<Reporte> getReportesByCategoriaEquals(String string);
}