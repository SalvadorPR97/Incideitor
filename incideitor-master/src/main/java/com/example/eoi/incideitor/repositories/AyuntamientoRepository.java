package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Ayuntamiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AyuntamientoRepository extends JpaRepository<Ayuntamiento, Integer> {

    /**
     * Obtiene una página de ayuntamientos cuyo nombre contiene (ignorando mayúsculas y minúsculas) el texto especificado.
     *
     * @param nombre    Texto a buscar en el nombre de los ayuntamientos
     * @param pageable  Información de paginación y ordenación
     * @return Página de ayuntamientos encontrados
     */
    Page<Ayuntamiento> findAllByNombreContainsIgnoreCase(String nombre, Pageable pageable);
}