package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Reporte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
    /**
     * Obtiene una página de reportes filtrados por categoría.
     *
     * @param categoria Categoría por la cual filtrar los reportes
     * @param pageable  Objeto de paginación para controlar la paginación de los resultados
     * @return Página de reportes filtrados por categoría
     */
    Page<Reporte> findAllByCategoriaEquals(String categoria, Pageable pageable);

    /**
     * Obtiene una página de reportes filtrados por categoría y que contengan un nombre específico en el título.
     *
     * @param categoria Categoría por la cual filtrar los reportes
     * @param nombre    Nombre a buscar en el título de los reportes
     * @param pageable  Objeto de paginación para controlar la paginación de los resultados
     * @return Página de reportes filtrados por categoría y título
     */
    Page<Reporte> findAllByCategoriaEqualsAndTituloContainsIgnoreCase(String categoria, String nombre, Pageable pageable);
}