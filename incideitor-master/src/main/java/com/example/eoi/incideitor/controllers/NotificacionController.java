package com.example.eoi.incideitor.controllers;

import com.example.eoi.incideitor.abstractcomponents.GenericServiceWithJPA;
import com.example.eoi.incideitor.dtos.ListaNotificacionesUsuarioDTO;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.Notificacion;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.NotificacionRepository;
import com.example.eoi.incideitor.util.ObtenerDatosUsuario;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.*;


@Log4j2
@Controller
public class NotificacionController {


    @Autowired
    ObtenerDatosUsuario obtenerDatosUsuario;


    public String contarNotificaciones(Model model) {

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

                //Añadimos el dto a la lista
                listaNotificacionesUsuarioDTOS.add(dto);
            }

            //Comprobamos si la lista no esta vacia, si no lo esta, asignamos el tamaño de la lista a numeroNotificaciones
            if (!listaNotificacionesUsuarioDTOS.isEmpty()){
                numeroNotificaciones = String.valueOf(listaNotificacionesUsuarioDTOS.size());
            }

        }

        //Devolvemos el numero de notificaciones
        return numeroNotificaciones;
    }



}