package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Notificacion;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NotificacionRepository extends PagingAndSortingRepository<Notificacion, Integer>, JpaRepository<Notificacion, Integer> {


    //Buscar por usuario y estado

}