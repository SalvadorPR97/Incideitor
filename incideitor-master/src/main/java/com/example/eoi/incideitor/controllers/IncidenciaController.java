package com.example.eoi.incideitor.controllers;

import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.TipoIncidencia;
import com.example.eoi.incideitor.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.example.eoi.incideitor.filemanagement.controllers.AppUploadController;
import com.example.eoi.incideitor.repositories.TipoIncidenciaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequestMapping("${url.incidencia}")
public class IncidenciaController extends MiControladorGenerico<Incidencia> {

    @Value("${url.incidencia}")
    private String url;

    private String entityName = "incidencia";

    @Autowired
    TipoIncidenciaRepository tipoIncidenciaRepository;

    @Autowired
    AppUploadController appUploadController;

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
    public String crearIncidencia(@ModelAttribute Incidencia incidencia, @RequestParam(required = false) MultipartFile file, HttpSession session , Model model) throws IOException {
        service.create(incidencia);
        appUploadController.uploadImgPost(file, session , model, incidencia.getId());
        return "redirect:/incidencia/admin";
    }


    @Override
    @GetMapping("/{id}")
    public String getById(@PathVariable Object id,  Model model) throws MiEntidadNoEncontradaException {
        try {
            Set<String> listaFotos = listFilesUsingJavaIO("src/main/resources/static/uploads/"+id);
            Incidencia entity = service.getById(id);
            model.addAttribute("entity", entity);
            model.addAttribute("entityName", entityName);
            model.addAttribute("nombreVista", "entity-details");
            model.addAttribute("listaFotos", listaFotos);
            return "index"; // Nombre de la plantilla para mostrar los detalles de una entidad

        } catch (MiEntidadNoEncontradaException ex) {
            return "error"; // Nombre de la plantilla para mostrar la página de error
        }
    }

    public Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

}

