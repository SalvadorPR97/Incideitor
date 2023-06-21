package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {


}