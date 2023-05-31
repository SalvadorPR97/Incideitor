package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Notificacion;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {


}