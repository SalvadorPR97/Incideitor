package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Foto;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepository extends JpaRepository<Foto, Integer> {


}