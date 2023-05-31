package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Historico;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface HistoricoRepository extends JpaRepository<Historico, Date> {


}