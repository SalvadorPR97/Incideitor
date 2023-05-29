package com.example.eoi.incideitor.controllers;

import com.example.eoi.incideitor.repositories.UsuarioRepository;
import com.example.eoi.incideitor.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;


    @GetMapping(value={"/",""})
    public String showIndex(Model model)
    {
        return "index";
    }



}
