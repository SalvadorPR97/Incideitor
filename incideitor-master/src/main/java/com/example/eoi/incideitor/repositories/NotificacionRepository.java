package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Notificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends PagingAndSortingRepository<Notificacion, Integer>, JpaRepository<Notificacion, Integer> {







}