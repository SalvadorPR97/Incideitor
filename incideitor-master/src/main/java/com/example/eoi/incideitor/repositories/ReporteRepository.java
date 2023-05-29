package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Reporte;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
}