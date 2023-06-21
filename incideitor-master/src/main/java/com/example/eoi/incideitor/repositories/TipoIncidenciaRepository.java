package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Historico;
import com.example.eoi.incideitor.entities.TipoIncidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TipoIncidenciaRepository extends JpaRepository<TipoIncidencia, Integer> {

    /**
     * Obtiene una lista de tipos de incidencia cuyo identificador de incidencia padre se encuentra en un rango dado.
     *
     * @param min Valor mínimo del identificador de incidencia padre
     * @param max Valor máximo del identificador de incidencia padre
     * @return Lista de tipos de incidencia encontrados
     */
    List<TipoIncidencia> findAllByIncidenciaPadre_IdBetween(int min, int max);


}