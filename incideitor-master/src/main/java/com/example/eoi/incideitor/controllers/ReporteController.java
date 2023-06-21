package com.example.eoi.incideitor.controllers;



import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.entities.Reporte;
import com.example.eoi.incideitor.repositories.ReporteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Controlador para la entidad Reporte.
 *
 * <p>Esta clase se encarga de manejar las solicitudes relacionadas con la entidad Reporte utilizando la funcionalidad proporcionada por
 * la clase {@link MiControladorGenerico}.</p>
 *
 * <p>Los principales componentes de esta clase son:</p>
 * <ul>
 *     <li>Inversión de control (IoC): La clase extiende MiControladorGenerico y utiliza la funcionalidad proporcionada por ella.
 *     Esto permite que los detalles de implementación sean proporcionados por la clase genérica y facilita la reutilización de código
 *     y la consistencia en la implementación de controladores.</li>
 *     <li>Inyección de dependencias (DI): La clase utiliza inyección de dependencias para obtener el nombre de la entidad gestionada.
 *     El valor de entityName se inyecta utilizando la anotación @Value en la propiedad correspondiente. Esto permite la separación de
 *     responsabilidades y mejora la mantenibilidad y escalabilidad del controlador.</li>
 *     <li>Principio de abstracción: La clase extiende la clase genérica MiControladorGenerico, lo que permite una implementación
 *     común de las operaciones CRUD para la entidad Reporte. Esto facilita la reutilización de código y mejora la consistencia en
 *     la implementación de controladores.</li>
 * </ul>
 *
 * "@param <Reporte>" El tipo de entidad gestionada por el controlador.
 * "@Author Alejandro Teixeira Muñoz
 */
@Controller
@RequestMapping("${url.reporte}")
public class ReporteController extends MiControladorGenerico<Reporte> {


    private final String entityName = "reporte";

    @Autowired
    ReporteRepository reporteRepository;

    @Autowired
    NotificacionController notificacionController;

    /**
     * Constructor de la clase UsuarioController.
     * Se utiliza para crear una instancia del controlador.
     */
    public ReporteController() {
        super();
    }

    /**
     * Método de inicialización para establecer el valor de entityName y entityPrefix.
     * El valor de entityName se obtiene de una propiedad configurada en un archivo de propiedades utilizando la anotación @Value.
     * Después de la construcción del objeto UsuarioController, se llama a este método para establecer los valores necesarios.
     *
     * @PostConstruct indica que este método debe ejecutarse después de que se haya construido el objeto ReporteController.
     * Es una anotación de JSR-250 y se utiliza para realizar tareas de inicialización una vez que todas las dependencias hayan sido inyectadas.
     * En este caso, se utiliza para asegurar que entityName y entityPrefix se establezcan correctamente después de la construcción del objeto.
     * @Author Alejandro Teixeira Muñoz
     */
    @PostConstruct
    private void init() {
        super.entityName = entityName;
    }


    /**
     * Maneja una solicitud GET a "/create" y muestra un formulario para crear un nuevo informe.
     *
     * @param model El modelo que se va a poblar con atributos para renderizar la vista.
     * @return El nombre de la plantilla de vista.
     */
    @GetMapping("/create")
    public String mostrarFormulario(Model model) {
        model.addAttribute("entity", new Reporte());
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "entity-details");
        return "index";
    }


    /**
     * Maneja una solicitud POST a "/create" y crea un nuevo informe.
     *
     * @param reporte El objeto Reporte recibido desde el formulario.
     * @return El nombre de la plantilla de vista de redirección.
     */
    @PostMapping("/create")
    public String crearReporte(@ModelAttribute Reporte reporte) {
        service.create(reporte);
        return "redirect:/";
    }


    /**
     * Maneja una solicitud GET a "/adminError" y muestra todos los reportes de categoría "Error".
     *
     * @param nombre El nombre del informe a buscar (opcional).
     * @param page El número de página actual.
     * @param size El tamaño de página.
     * @param model El modelo que se va a poblar con atributos para renderizar la vista.
     * @return El nombre de la plantilla de vista.
     */
    @GetMapping("/adminError")
    public String getAllAdminError(@RequestParam(required = false) String nombre, @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {


            if (!Objects.equals(notificacionController.contarNotificaciones(model), "0")){
                String contador = notificacionController.contarNotificaciones(model);
                model.addAttribute("contador",contador);
            }

            Pageable pageable = PageRequest.of(page-1, size);

        Page<Reporte> entities;
        // Si nos viene informado el nombre, devolveremos la lista filtrada.
        if (nombre == null){
            entities = reporteRepository.findAllByCategoriaEquals("Error",pageable);
        } else {
            entities = reporteRepository.findAllByCategoriaEqualsAndTituloContainsIgnoreCase("Error", nombre, pageable);
        }


        int totalPages = entities.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("entities", entities);
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "admin");
        return "index"; // Nombre de la plantilla para mostrar todas las entidades
    }


    /**
     * Maneja una solicitud GET a "/adminError" y muestra todos los reportes de categoría "Error".
     *
     * @param nombre El nombre del informe a buscar (opcional).
     * @param page El número de página actual.
     * @param size El tamaño de página.
     * @param model El modelo que se va a poblar con atributos para renderizar la vista.
     * @return El nombre de la plantilla de vista.
     */
    @GetMapping("/adminBugs")
    public String getAllAdminBugs(@RequestParam(required = false) String nombre, @RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   Model model) {


        if (!Objects.equals(notificacionController.contarNotificaciones(model), "0")){
            String contador = notificacionController.contarNotificaciones(model);
            model.addAttribute("contador",contador);
        }

        Pageable pageable = PageRequest.of(page-1, size);

        Page<Reporte> entities;
        // Si nos viene informado el nombre, devolveremos la lista filtrada.
        if (nombre == null){
            entities = reporteRepository.findAllByCategoriaEquals("Bug",pageable);
        } else {
            entities = reporteRepository.findAllByCategoriaEqualsAndTituloContainsIgnoreCase("Bug", nombre, pageable);
        }


        int totalPages = entities.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("entities", entities);
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "admin");
        return "index"; // Nombre de la plantilla para mostrar todas las entidades
    }


}