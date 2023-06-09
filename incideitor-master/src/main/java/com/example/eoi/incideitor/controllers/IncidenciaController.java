package com.example.eoi.incideitor.controllers;

import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.TipoIncidencia;
import com.example.eoi.incideitor.repositories.TipoIncidenciaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("${url.incidencia}")
public class IncidenciaController extends MiControladorGenerico<Incidencia> {

    @Value("${url.incidencia}")
    private String url;

    private String entityName = "incidencia";

    @Autowired
    TipoIncidenciaRepository tipoIncidenciaRepository;


    /**
     * Constructor de la clase UsuarioController.
     * Se utiliza para crear una instancia del controlador.
     */
    public IncidenciaController() {
        super();
    }

    /**
     * Método de inicialización para establecer el valor de entityName y entityPrefix.
     * El valor de entityName se obtiene de una propiedad configurada en un archivo de propiedades utilizando la anotación @Value.
     * Después de la construcción del objeto UsuarioController, se llama a este método para establecer los valores necesarios.
     *
     * @PostConstruct indica que este método debe ejecutarse después de que se haya construido el objeto UsuarioController.
     * Es una anotación de JSR-250 y se utiliza para realizar tareas de inicialización una vez que todas las dependencias hayan sido inyectadas.
     * En este caso, se utiliza para asegurar que entityName y entityPrefix se establezcan correctamente después de la construcción del objeto.
     * @Author Alejandro Teixeira Muñoz
     */
    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }

    @GetMapping("/create")
    public String mostrarFormulario(@RequestParam(value = "incidenciaPadre", required = false) Long incidenciaPadre, Model model) {
        List<TipoIncidencia> tiposIncidencias = tipoIncidenciaRepository.findAll();

        model.addAttribute("tiposIncidencia", tiposIncidencias);
        model.addAttribute("incidenciaPadre", incidenciaPadre);
        model.addAttribute("entity", new Incidencia());
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "registro");
        return "index";
    }

    /**
     * Maneja la solicitud POST para crear una nueva entidad.
     *
     * @param "entity" La entidad a crear.
     * @param "model"  El objeto Model para agregar los atributos necesarios.
     * @return El nombre de la plantilla para mostrar los detalles de la entidad creada.
     */
    @PostMapping("/create")
    public String crearIncidencia(@ModelAttribute Incidencia incidencia) {
        service.create(incidencia);
        return "redirect:/incidencia/admin";
    }

}

