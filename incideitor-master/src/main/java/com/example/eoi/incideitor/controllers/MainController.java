package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.util.FileUploadUtil;
import com.example.eoi.incideitor.repositories.IncidenciaRepository;
import com.example.eoi.incideitor.services.AyuntamientoService;
import com.example.eoi.incideitor.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
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

    @Autowired
    NotificacionController notificacionController;


    /**
     * Muestra la página de inicio y carga las últimas incidencias y sus fotos.
     *
     * @param page  El número de página a mostrar.
     * @param size  El tamaño de página.
     * @param model El modelo de datos para la vista.
     * @return El nombre de la plantilla de la vista.
     */
    @GetMapping(value={"","/"})
    public String mostrarIndex(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int size,Model model)
    {
        //Sacamos del repositorio todas las incidencias ordenadas de por id en orden descendente
        List<Incidencia> incidencias = incidenciaRepository.obtenerUltimaIncidenciaArreglada();
        if(!incidencias.isEmpty()){
            //Buscamos si hay incidencias presentes y en caso afirmativo cogemos la primera que nos encontremos
            Incidencia ultimaIncidencia = incidencias.get(0);
            model.addAttribute("ultimaIncidencia", ultimaIncidencia);
            //De la incidencia que hemos cogido sacamos de su colección de fotos las que tenga asociadas para
            //mostrarlas en un carrusel en la pagina principal
            Set<String> listaFotos1 = fileUploadUtil.listFilesUsingJavaIO("src/main/resources/static/uploads/incidencia/"+ ultimaIncidencia.getId());
            model.addAttribute("listaFotos1", listaFotos1);

            //Buscamos la siguiente incidencia y repetimos el mismo proceso
            Incidencia penultimaIncidencia = incidencias.get(1);
            model.addAttribute("penultimaIncidencia", penultimaIncidencia);
            Set<String> listaFotos2 = fileUploadUtil.listFilesUsingJavaIO("src/main/resources/static/uploads/incidencia/"+ penultimaIncidencia.getId());
            model.addAttribute("listaFotos2", listaFotos2);

            //Buscamos la siguiente incidencia y repetimos el mismo proceso
            Incidencia antepenultimaIncidencia = incidencias.get(2);
            model.addAttribute("antepenultimaIncidencia", antepenultimaIncidencia);
            Set<String> listaFotos3 = fileUploadUtil.listFilesUsingJavaIO("src/main/resources/static/uploads/incidencia/"+ antepenultimaIncidencia.getId());
            model.addAttribute("listaFotos3", listaFotos3);
        }


        if (!Objects.equals(notificacionController.contarNotificaciones(model), "0")){
            String contador = notificacionController.contarNotificaciones(model);
            model.addAttribute("contador",contador);
        }

        //Aquí al Model le pasamos el entityName de home y al nombrevista lo llamamos principal para que el index
        //nos muestre el resultado en la pagina principal
        model.addAttribute("entityName", "home");
        model.addAttribute("nombreVista", "principal");
        return "index";
    }



    /**
     * Muestra la página "Acerca de".
     *
     * @param model El modelo de datos para la vista.
     * @return El nombre de la plantilla de la vista.
     */
    @GetMapping(value = {"/about"})
    public String mostrarAbout(Model model) {
        model.addAttribute("entityName", "home");
        model.addAttribute("nombreVista", "about");
        return "index";
    }

    /**
     * Muestra la página de "Términos y Condiciones".
     *
     * @param model El modelo de datos para la vista.
     * @return El nombre de la plantilla de la vista.
     */
    @GetMapping(value = {"/terminos-y-condiciones"})
    public String mostrarTerminos(Model model) {
        model.addAttribute("entityName", "home");
        model.addAttribute("nombreVista", "terminos-y-condiciones");
        return "index";
    }







}
