package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Permiso;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {


}