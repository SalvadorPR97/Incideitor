package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.repositories.UsuarioRepository;
import com.example.eoi.incideitor.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Implementación de servicio de seguridad de usuario que implementa la interfaz IUsuarioServicio
 * y la interfaz UserDetailsService de Spring Security.
 */
@Service
public class UsuarioSecurityImpl implements IUsuarioServicio, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    /**
     * Obtiene la contraseña codificada de un usuario.
     * @param usuario El usuario del cual se desea obtener la contraseña codificada.
     * @return La contraseña codificada del usuario.
     */
    @Override
    public String getEncodedPassword(Usuario usuario) {
        String passwd = usuario.getContrasena();
        String encodedPasswod = passwordEncoder.encode(passwd);
        return encodedPasswod;
    }

    /**
     * Carga los detalles del usuario por su nombre de usuario (email).
     * @param email El nombre de usuario (email) del usuario.
     * @return Un objeto UserDetails que representa los detalles del usuario.
     * @throws UsernameNotFoundException Si el usuario no puede ser encontrado.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername email : " + email);
        Optional<Usuario> usuario= usuarioRepository.findUsuarioByEmail(email);


        org.springframework.security.core.userdetails.User springUser=null;

        Set<GrantedAuthority> ga = new HashSet<>();
        if (usuario.isPresent()){
            System.out.println("loadUserByUsername usuario : " + usuario.get().getNombre());
            System.out.println("loadUserByRole rol : " + usuario.get().getRol().getNombre());
            ga.add(new SimpleGrantedAuthority(usuario.get().getRol().getNombre()));

            springUser = new org.springframework.security.core.userdetails.User(
                    email,
                    usuario.get().getContrasena(),
                    ga );
        }
        System.out.println("springUser = " + springUser);
        return springUser;
    }

}


