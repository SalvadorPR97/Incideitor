package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import com.example.eoi.incideitor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/incidencias")
@Controller
public class IncidenciasController extends MiControladorGenerico {
    @Autowired
    UserService userService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    public String showUsuarios(Model model)
    {
        Optional<Usuario> usuario = userService.getUserByID(1);
        if(usuario.isPresent())
        {
            model.addAttribute("nombre",usuario.get().getNombre());
        }
        else
        {
            model.addAttribute("nombre","Sin nombre");
        }

        //busco todos los usuarios y los añado al modelo
        model.addAttribute("usuarios",userService.findAll());

        return "usuarios";
    }



    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id)
    {
        usuarioRepository.deleteById(id);
        return  "redirect:/usuarios";
    }


    @GetMapping("/edit/{id}")
    public String deleteUser(@PathVariable Integer id, Model model)
    {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent())
        {
            model.addAttribute("usuario",usuario.get());
        }
        return  "userForm";
    }


    @PostMapping("/save")
    public String saveUser(Usuario usuario)
    {
        usuarioRepository.save(usuario);
        return  "redirect:/usuarios";
    }

}
