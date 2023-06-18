package com.example.eoi.incideitor.controllers;

import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.entities.Ayuntamiento;
import com.example.eoi.incideitor.entities.Foto;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.TipoIncidencia;
import com.example.eoi.incideitor.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.example.eoi.incideitor.filemanagement.util.FileUploadUtil;
import com.example.eoi.incideitor.repositories.IncidenciaRepository;
import com.example.eoi.incideitor.repositories.TipoIncidenciaRepository;
import com.example.eoi.incideitor.services.FotoService;
import com.example.eoi.incideitor.services.NotificacionService;
import com.example.eoi.incideitor.util.ObtenerDatosUsuario;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
@RequestMapping("${url.incidencia}")
public class IncidenciaController extends MiControladorGenerico<Incidencia> {

    @Value("${url.incidencia}")
    private String url;

    private String entityName = "incidencia";

    @Autowired
    TipoIncidenciaRepository tipoIncidenciaRepository;

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Autowired
    FotoService fotoService;

    @Autowired
    ObtenerDatosUsuario obtenerDatosUsuario;

    @Autowired
    NotificacionService notificacionService;

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @Autowired
    NotificacionController notificacionController;

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
    public String crearIncidencia(@ModelAttribute Incidencia incidencia, @RequestParam(required = false) MultipartFile file, @RequestParam(required = false) MultipartFile file2, @RequestParam(required = false) MultipartFile file3) throws IOException {
        // Generamos la fecha actual para añadirla como fecha de creacion
        incidencia.setFecha(LocalDate.now());
        //Obtenemos el usuario de la sesión y la añadimos a la incidencia
        incidencia.setUsuario(obtenerDatosUsuario.getUserData());
        service.create(incidencia);

        notificacionService.crearNotificacion(incidencia,"Incidencia creada");


        // Usamos el metodo de fileUploadutil para crear las fotos en su directorio correspondiente
        List<String> listaurls = fileUploadUtil.uploadImgIncidencia(file,file2,file3, incidencia.getId());

        // Creamos la colección de fotos para añadirla a la nueva incidencia
        Collection<Foto> fotos = new HashSet<>();
        // Recorremos la lista de urls donde están las fotos para añadirlas a la colección
        for (int i = 0; i < listaurls.size(); i++) {
            String url = listaurls.get(i);
            Foto foto = new Foto();
            foto.setUrl(url);
            foto.setOrden(i);
            foto.setIncidencia(incidencia);
            fotos.add(foto);
            fotoService.create(foto);

        }
        // Añadimos la coleccion de fotos que rellenamos a la incidencia
        incidencia.setFotos(fotos);
        // Creamos la incidencia en la BDD
        service.update(incidencia);
        return "redirect:/incidencia/admin";
    }


    @Override
    @GetMapping("/{id}")
    public String getById(@PathVariable Object id,  Model model) throws MiEntidadNoEncontradaException {
        try {
            Set<String> listaFotos = fileUploadUtil.listFilesUsingJavaIO("src/main/resources/static/uploads/incidencia/"+id);
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




    @GetMapping("/adminBusq")
    public String getAllAdmin(@RequestParam(required = false) Integer tipoIncidencia, @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {

        if (!Objects.equals(notificacionController.contarNotificaciones(model), "0")){
            String contador = notificacionController.contarNotificaciones(model);
            model.addAttribute("contador",contador);
        }

        Pageable pageable = PageRequest.of(page-1, size);


        Page<Incidencia> entities;
        if (tipoIncidencia == null){
            entities = incidenciaRepository.findAll(pageable);
        } else {
            entities = incidenciaRepository.findAllByTipoIncidencia_Id(tipoIncidencia, pageable);
        }


        int totalPages = entities.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        List<TipoIncidencia> tiposIncidencias = tipoIncidenciaRepository.findAllByIncidenciaPadre_IdBetween(1,999998);

        model.addAttribute("tiposIncidencia", tiposIncidencias);
        model.addAttribute("entities", entities);
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "admin");
        return "index"; // Nombre de la plantilla para mostrar todas las entidades
    }



}

