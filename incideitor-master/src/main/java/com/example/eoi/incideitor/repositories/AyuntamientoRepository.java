package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Ayuntamiento;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AyuntamientoRepository extends JpaRepository<Ayuntamiento, Integer> {

    Page<Ayuntamiento> findAllByNombreContainsIgnoreCase(String nombre, Pageable pageable);
}