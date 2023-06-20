package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Reporte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
    Page<Reporte> findAllByCategoriaEquals(String categoria, Pageable pageable);

    Page<Reporte> findAllByCategoriaEqualsAndTituloContainsIgnoreCase(String categoria, String nombre , Pageable pageable);
}