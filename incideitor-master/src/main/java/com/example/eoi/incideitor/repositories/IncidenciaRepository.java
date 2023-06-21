package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Incidencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {

    /**
     * Obtiene la lista de las últimas incidencias ordenadas por su identificador en orden descendente.
     *
     * @return Lista de las últimas incidencias
     */
    @Query("SELECT i FROM Incidencia i ORDER BY i.id ASC")
    List<Incidencia> obtenerUltimaIncidenciaArreglada();

    @Override
    Page<Incidencia> findAll(Pageable pageable);

    /**
     * Obtiene una página de incidencias relacionadas con un tipo de incidencia específico.
     *
     * @param tipoIncidencia  Identificador del tipo de incidencia
     * @param pageable        Información de paginación y ordenación
     * @return Página de incidencias del tipo especificado
     */
    Page<Incidencia> findAllByTipoIncidencia_Id(Object tipoIncidencia, Pageable pageable);

    Page<Incidencia> findAllByUsuarioId(int idUsuario, Pageable pageable);

    Page<Incidencia> findAllByUsuarioIdAndTipoIncidencia_Id(int idUsuario, Object tipoIncidencia, Pageable pageable);
}