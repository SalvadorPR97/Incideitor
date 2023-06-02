package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.entities.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, String> {


}