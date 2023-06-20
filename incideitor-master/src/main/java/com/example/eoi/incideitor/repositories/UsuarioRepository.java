package com.example.eoi.incideitor.repositories;

import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email Correo electrónico del usuario
     * @return Usuario encontrado (opcional)
     */
    Optional<Usuario> findUsuarioByEmail(String email);

    /**
     * Busca un usuario por su correo electrónico y contraseña.
     *
     * @param email      Correo electrónico del usuario
     * @param contrasena Contraseña del usuario
     * @return Usuario encontrado (opcional)
     */
    Optional<Usuario> findUsuarioByEmailAndContrasena(String email, String contrasena);

    /**
     * Busca un usuario por su correo electrónico y token.
     *
     * @param email Correo electrónico del usuario
     * @param token Token del usuario
     * @return Usuario encontrado (opcional)
     */
    Optional<Usuario> findByEmailAndToken(String email, String token);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email Correo electrónico del usuario
     * @return Usuario encontrado (opcional)
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Busca un usuario por su token.
     *
     * @param token Token del usuario
     * @return Usuario encontrado (opcional)
     */
    Optional<Usuario> findByToken(String token);

    /**
     * Busca usuarios cuyo nombre contiene la cadena proporcionada, de manera insensible a mayúsculas o minúsculas.
     *
     * @param nombre   Cadena a buscar en el nombre de los usuarios
     * @param pageable Paginación de los resultados
     * @return Página de usuarios encontrados
     */
    Page<Usuario> findAllByNombreContainsIgnoreCase(String nombre, Pageable pageable);

}