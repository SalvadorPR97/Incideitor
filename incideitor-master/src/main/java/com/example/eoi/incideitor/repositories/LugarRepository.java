package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Lugar;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LugarRepository extends JpaRepository<Lugar, Integer> {


}