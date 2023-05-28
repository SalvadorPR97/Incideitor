package com.example.eoi.incideitor.controllers;

import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import com.example.eoi.incideitor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    UsuarioRepository usuarioRepository;


    @GetMapping(value={"/",""})
    public String showIndex(Model model)
    {
        return "index";
    }



}
