package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends PagingAndSortingRepository<Notificacion, Integer>, JpaRepository<Notificacion, Integer> {

    /**
     * Obtiene una lista de notificaciones no borradas.
     *
     * @param borradoLogico Valor que indica si la notificación ha sido borrada lógicamente (0: no borrada, 1: borrada)
     * @return Lista de notificaciones no borradas
     */
    List<Notificacion> findByBorradoLogico(int borradoLogico);



}