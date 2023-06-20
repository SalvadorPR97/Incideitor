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

    //Metodo para obtener los datos del usuario que se encuentra actualmente autenticado
    public Usuario getUserData(){
        String  userName = "no informado";

        //Se imprime en la consola el resultado de llamar al método toString para ver que informacion obtenemos del usuario
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        //Creamos un usuario vacío
        Usuario usuario = new Usuario();
        //Comprobamos si hay usuario autenticado, comparando con la cadena "anonymosUser", si es igual asignamos el siguiente userName
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userName = "anonimo@anonimo.com";
        } else {
            //Si se encuentra un usuario autenticado, distinto a "anonimousUser", obtenemos su nombre de usuario y lo asignamos a la variable
            userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            //Obtenemos datos del usuario
        }
        //Buscamos un usuario en la base de datos correspondiente al nombre de "userName"
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmail(userName);
        //Si se encuentra, se le asigna al objeto usuario el usuario encontrado
        if (usuarioOptional.isPresent()){
            usuario = usuarioOptional.get();
        }

        //Devolvemos el objeto usuario
        return usuario;
    }
}
