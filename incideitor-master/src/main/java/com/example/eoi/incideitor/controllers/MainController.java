package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.dtos.IncidenciaDatos;
import com.example.eoi.incideitor.entities.Foto;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.filemanagement.util.FileUploadUtil;
import com.example.eoi.incideitor.repositories.IncidenciaRepository;
import com.example.eoi.incideitor.services.AyuntamientoService;
import com.example.eoi.incideitor.services.UsuarioService;
import com.example.eoi.incideitor.util.ObtenerDatosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AyuntamientoService ayuntamientoService;

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @Autowired
    private FileUploadUtil fileUploadUtil;




    @GetMapping(value={"","/"})
    public String mostrarIndex(Model model)
    {
        //Lectura del usuaro activo en la sesión


        List<Incidencia> incidencias = incidenciaRepository.obtenerUltimaIncidencia();
        if(!incidencias.isEmpty()){
            Incidencia ultimaIncidencia = incidencias.get(0);
            model.addAttribute("ultimaIncidencia", ultimaIncidencia);
            Set<String> listaFotos1 = fileUploadUtil.listFilesUsingJavaIO("src/main/resources/static/uploads/"+ ultimaIncidencia.getId());
            model.addAttribute("listaFotos1", listaFotos1);

            Incidencia penultimaIncidencia = incidencias.get(1);
            model.addAttribute("penultimaIncidencia", penultimaIncidencia);
            Set<String> listaFotos2 = fileUploadUtil.listFilesUsingJavaIO("src/main/resources/static/uploads/"+ penultimaIncidencia.getId());
            model.addAttribute("listaFotos2", listaFotos2);

            Incidencia antepenultimaIncidencia = incidencias.get(2);
            model.addAttribute("antepenultimaIncidencia", antepenultimaIncidencia);
            Set<String> listaFotos3 = fileUploadUtil.listFilesUsingJavaIO("src/main/resources/static/uploads/"+ antepenultimaIncidencia.getId());
            model.addAttribute("listaFotos3", listaFotos3);
        }
        model.addAttribute("entityName", "home");
        model.addAttribute("nombreVista", "principal");
        return "index";
    }



    @GetMapping(value={"/about"})
    public String mostrarAbout(Model model)
    {
        model.addAttribute("entityName", "home");
        model.addAttribute("nombreVista", "about");
        return "index";
    }

    @GetMapping(value={"/terminos-y-condiciones"})
    public String mostrarTerminos(Model model)
    {
        model.addAttribute("entityName", "home");
        model.addAttribute("nombreVista", "terminos-y-condiciones");
        return "index";
    }







}
