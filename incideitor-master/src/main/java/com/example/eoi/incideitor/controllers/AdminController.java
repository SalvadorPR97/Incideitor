package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class AdminController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    NotificacionController notificacionController;

    @GetMapping(value={"/admin"})
    public String mostrarIndex(Model model)
    {

        if (!Objects.equals(notificacionController.contarNotificaciones(model), "0")){
            String contador = notificacionController.contarNotificaciones(model);
            model.addAttribute("contador",contador);
        }
        model.addAttribute("entityName", "admin");
        model.addAttribute("nombreVista", "principal");
        return "index";
    }



}
