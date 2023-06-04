package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.services.AyuntamientoService;
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
    AyuntamientoService ayuntamientoService;



    @GetMapping(value={"","/"})
    public String mostrarIndex(Model model)
    {
        model.addAttribute("entityName", "home");
        model.addAttribute("nombreVista", "principal");
        return "index";
    }

    @GetMapping(value={"/login","/acceso/login"})
    public String mostrarLogin(Model model)
    {
        model.addAttribute("entityName", "acceso");
        model.addAttribute("nombreVista", "login");
        return "index";
    }

    @GetMapping(value={"/about"})
    public String mostrarAbout(Model model)
    {
        model.addAttribute("entityName", "home");
        model.addAttribute("nombreVista", "about");
        return "index";
    }



}
