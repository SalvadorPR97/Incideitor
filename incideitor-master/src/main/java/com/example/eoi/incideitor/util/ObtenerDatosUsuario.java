package com.example.eoi.incideitor.util;

import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObtenerDatosUsuario {

    @Autowired
     UsuarioRepository usuarioRepository;

    public Usuario getUserData(){
        String  userName = "no informado";
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        Usuario usuario = new Usuario();
        //Comprobamos si hay usuario logeado
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userName = "anonimo@anonimo.com";
        } else {
            userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            //Obtenemos datos del usuario
        }
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmail(userName);
        if (usuarioOptional.isPresent()){
            usuario = usuarioOptional.get();
        }

        return usuario;
    }
}
