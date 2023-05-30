package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    UsuarioService usuarioService;



    @GetMapping(value={"","/"})
    public String mostrarIndex(Model model)
    {
        model.addAttribute("entityName", "index");
        model.addAttribute("nombreVista", "principal");
        return "index";
    }



}
