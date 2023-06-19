package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.dtos.AyuntamientoDTO;
import com.example.eoi.incideitor.entities.Ayuntamiento;
import com.example.eoi.incideitor.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.example.eoi.incideitor.services.AyuntamientoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**

 Controlador para la entidad Ayuntamiento.

 Esta clase se encarga de manejar las solicitudes relacionadas con la entidad Ayuntamiento utilizando la funcionalidad proporcionada por
 la clase {@link MiControladorGenerico}.

 Los principales componentes de esta clase son:

 Inversión de control (IoC): La clase extiende MiControladorGenerico y utiliza la funcionalidad proporcionada por ella.
 Esto permite que los detalles de implementación sean proporcionados por la clase genérica y facilita la reutilización de código
 y la consistencia en la implementación de controladores.

 Inyección de dependencias (DI): La clase utiliza inyección de dependencias para obtener el nombre de la entidad gestionada.
 El valor de entityName se inyecta utilizando la anotación @Value en la propiedad correspondiente. Esto permite la separación de
 responsabilidades y mejora la mantenibilidad y escalabilidad del controlador.

 Principio de abstracción: La clase extiende la clase genérica MiControladorGenerico, lo que permite una implementación
 común de las operaciones CRUD para la entidad Ayuntamiento. Esto facilita la reutilización de código y mejora la consistencia en
 la implementación de controladores.

 @param <Ayuntamiento> El tipo de entidad gestionada por el controlador.
 */
@Controller
@RequestMapping("${url.ayuntamiento}")
public class AyuntamientoController extends MiControladorGenerico<Ayuntamiento> {

    private final String entityName = "ayuntamiento";

    @Autowired
    AyuntamientoService ayuntamientoService;

    /**

     Constructor de la clase AyuntamientoController.
     Se utiliza para crear una instancia del controlador.
     */
    public AyuntamientoController() {
        super();
    }
    /**

     Método de inicialización para establecer el valor de entityName.
     El valor de entityName se obtiene de una propiedad configurada en un archivo de propiedades.
     Después de la construcción del objeto AyuntamientoController, se llama a este método para establecer los valores necesarios.

     @PostConstruct indica que este método debe ejecutarse después de que se haya construido el objeto AyuntamientoController.
     Es una anotación de JSR-250 y se utiliza para realizar tareas de inicialización una vez que todas las dependencias hayan sido inyectadas.
     En este caso, se utiliza para asegurar que entityName se establezca correctamente después de la construcción del objeto.
¡     */
    @PostConstruct
    private void init() {
        super.entityName = entityName;
    }
    /**

     Muestra el formulario para crear un nuevo Ayuntamiento.
     @param model El modelo de datos para la vista.
     @return El nombre de la plantilla de la vista.
     */
    @GetMapping("/create")
    public String mostrarFormulario(Model model) {
        model.addAttribute("entity", new Ayuntamiento());
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "entity-details");
        return "index";
    }
    /**

     Crea un nuevo Ayuntamiento.
     @param ayuntamiento El objeto Ayuntamiento a crear.
     @return La redirección a la página de administración de Ayuntamiento.
     */
    @PostMapping("/create")
    public String crearUsuario(@ModelAttribute Ayuntamiento ayuntamiento) {
        service.create(ayuntamiento);
        return "redirect:/ayuntamiento/admin";
    }
    /**

     Muestra el formulario para editar un Ayuntamiento.
     @param id El ID del Ayuntamiento a editar.
     @param model El modelo de datos para la vista.
     @return El nombre de la plantilla de la vista.
     @throws MiEntidadNoEncontradaException Si no se encuentra el Ayuntamiento.
     */
    @GetMapping("/edit/{id}")
    public String editDto(@PathVariable Object id, Model model) throws MiEntidadNoEncontradaException {
        try {
            Ayuntamiento ayuntamiento = service.getById(id);
            AyuntamientoDTO dto = this.ayuntamientoService.leerDatosAyuntamiento(ayuntamiento.getId());
            model.addAttribute("entity", dto);
            model.addAttribute("entityName", entityName);
            model.addAttribute("nombreVista", "entity-details");
            return "index"; // Nombre de la plantilla para mostrar los detalles de una entidad
        } catch (MiEntidadNoEncontradaException ex) {
            return "error"; // Nombre de la plantilla para mostrar la página de error
        }
    }
    /**

     Guarda los datos de un Ayuntamiento editado.
     @param dto El objeto AyuntamientoDTO con los datos editados del Ayuntamiento.
     @return La redirección a la página de administración de Ayuntamiento.
     */
    @PostMapping("/edit/{id}")
    public String saveDto (@ModelAttribute AyuntamientoDTO dto){
        this.ayuntamientoService.guardarDatosAyuntamiento(dto);
        return "redirect:/" + entityName + "/admin";
    }
}