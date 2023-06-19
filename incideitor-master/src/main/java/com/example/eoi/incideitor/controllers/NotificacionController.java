package com.example.eoi.incideitor.controllers;

import com.example.eoi.incideitor.abstractcomponents.GenericServiceWithJPA;
import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.dtos.ListaNotificacionesUsuarioDTO;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.Notificacion;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.NotificacionRepository;
import com.example.eoi.incideitor.util.ObtenerDatosUsuario;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Log4j2
@Controller
@RequestMapping("${url.notificacion}")
public class NotificacionController{


    @Value("misNotificaciones")
    private String url;

    private String entityName = "notificacion";

    @Autowired
    ObtenerDatosUsuario obtenerDatosUsuario;

    @Autowired
    private NotificacionRepository notificacionRepository;

    @ModelAttribute("misNotificaciones")
    public List<ListaNotificacionesUsuarioDTO> obtenerNotificaciones(Model model) {

        //Obtenemos el usuario de la sesion
        Usuario usuario = obtenerDatosUsuario.getUserData();

        //Inicializamos la variable para contar las notificaciones
        String numeroNotificaciones = "0";

        //Generamos la lista a mostrar en la pantalla

        //Creamos una lista de tipo collection y guardamos en ella las incidencias del usuario
        Collection<Incidencia> listaIncidencias = usuario.getIncidencias();
        //Creamos una lista para almacenar el objeto DTO
        List<ListaNotificacionesUsuarioDTO> listaNotificacionesUsuarioDTOS = new ArrayList<ListaNotificacionesUsuarioDTO>();

        //Se inicia un bucle for para recorrer la lista de incidencias utilizando un iterador.
        for (Iterator<Incidencia> iterator = listaIncidencias.iterator();
             iterator.hasNext(); ) {

            //Para cada incidencia obtenemos la coleccion de notificaciones que tenga asociada
            Incidencia incidenciaLectura = iterator.next();
            Collection<Notificacion> notificacions = incidenciaLectura.getNotificaciones();

            //Se inicia otro bucle for para recorrer la colección de notificaciones utilizando un iterador.
            for (Iterator<Notificacion> iteratorN = notificacions.iterator();
                 iteratorN.hasNext(); ) {

                //Para cada notificacion creamos un objeto "dto" al que asignamos los valores correspondientes de la incidencia y de la notificacion.
                Notificacion notificacionLectura = iteratorN.next();

                ListaNotificacionesUsuarioDTO dto = new ListaNotificacionesUsuarioDTO();
                dto.setIdIncidencia(incidenciaLectura.getId());
                dto.setTituloIncidencia(incidenciaLectura.getDescripcion());
                dto.setId(notificacionLectura.getId());
                dto.setDescripcion(notificacionLectura.getDescripcion());
                dto.setFechaNotificacion(notificacionLectura.getFechaNotificacion());
                dto.setBorradoLogico(notificacionLectura.getBorradoLogico());

                //Añadimos el dto a la lista asegurando que solo se añade si no ha sido marcada como borrada
                if (notificacionLectura.getBorradoLogico() == 0) {
                    listaNotificacionesUsuarioDTOS.add(dto);
                }

            }

        }

        //Devolvemos la lista de notificaciones
        return listaNotificacionesUsuarioDTOS;
    }


    public String contarNotificaciones(Model model) {
        // Obtener la lista de notificaciones
        List<ListaNotificacionesUsuarioDTO> listaNotificaciones = obtenerNotificaciones(model);
        String numeroNotificaciones;

        //Comprobamos si la lista no esta vacia, si no lo esta, asignamos el tamaño de la lista a numeroNotificaciones
        if (listaNotificaciones.isEmpty()) {
            numeroNotificaciones = "0";
        } else {
            numeroNotificaciones = String.valueOf(listaNotificaciones.size());
        }

        //Devolvemos el numero de notificaciones
        return numeroNotificaciones;
    }


    //Metodo para mostrar la lista de notificaciones de forma paginada
    @GetMapping("/misNotificaciones")
    public String misIncidencias(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 Model model) {


        //Obtenemos las notificaciones
        List<ListaNotificacionesUsuarioDTO> listaNotificacionesUsuarioDTOS = obtenerNotificaciones(model);


        //Contamos las notificaciones
        if (!Objects.equals(contarNotificaciones(model), "0")){
            String contador = contarNotificaciones(model);
            model.addAttribute("contador",contador);
        }

        //Creamos la paginacion para la lista de notificaciones

        //Creamos un objeto pageable y ajustamos el índice de página a base cero
        Pageable pageable = PageRequest.of(page-1, size);

        //Se calcula el límite inferior y superior para la sublista que crearemos a continuacion
        int lowerBound = pageable.getPageNumber() * pageable.getPageSize();
        int upperBound = Math.min(lowerBound + pageable.getPageSize() - 1, listaNotificacionesUsuarioDTOS.size());

        //Creamos la sublista
        List<ListaNotificacionesUsuarioDTO> subList = listaNotificacionesUsuarioDTOS.subList(lowerBound, upperBound);

        //Creamos un objeto "PageImpl" con la sublista, el indice de la pagina y el tamaño de la sublista
        Page<ListaNotificacionesUsuarioDTO> listaNotificacionesUsuarioDTOPage = new PageImpl<ListaNotificacionesUsuarioDTO>(subList, pageable, subList.size());

        //Obtenemos el numero total de paginas
        int totalPages = listaNotificacionesUsuarioDTOPage.getTotalPages();

        //Si el número total de páginas es mayor que cero, se crea una lista de números de página llamada "pageNumbers" y añadimos el model
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }


        //Añadimos los model para poder mostrar en la vista y redirigimos a la plantilla "index"
        model.addAttribute("entities", listaNotificacionesUsuarioDTOPage);
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", url);
        return "index"; // Nombre de la plantilla para mostrar todas las entidades
    }

}