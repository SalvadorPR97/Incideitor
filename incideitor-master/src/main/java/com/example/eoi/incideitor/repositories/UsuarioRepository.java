package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Notificacion;
import com.example.eoi.incideitor.entities.Usuario;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findUsuarioByEmail(String email);

    Optional<Usuario> findUsuarioByEmailAndContrasena(String email,String contrasena);

    Optional<Usuario> findByEmailAndToken(String name, String token);

    Optional<Usuario> findByEmail(String name);

    Optional<Usuario> findByToken(String token);

    Page<Usuario> findAllByNombreContainsIgnoreCase(String nombre, Pageable pageable);






}