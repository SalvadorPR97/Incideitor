package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Historico;
import com.example.eoi.incideitor.entities.TipoIncidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TipoIncidenciaRepository extends JpaRepository<TipoIncidencia, Integer> {


}