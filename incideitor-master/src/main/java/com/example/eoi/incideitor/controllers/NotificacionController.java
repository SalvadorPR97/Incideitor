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
        Collection<Incidencia> listaIncidencias = usuario.getIncidencias();
        List<ListaNotificacionesUsuarioDTO> listaNotificacionesUsuarioDTOS = new ArrayList<ListaNotificacionesUsuarioDTO>();

        for (Iterator<Incidencia> iterator = listaIncidencias.iterator();
             iterator.hasNext(); ) {
            Incidencia incidenciaLectura = iterator.next();
            Collection<Notificacion> notificacions = incidenciaLectura.getNotificaciones();
            for (Iterator<Notificacion> iteratorN = notificacions.iterator();
                 iteratorN.hasNext(); ) {
                Notificacion notificacionLectura = iteratorN.next();

                ListaNotificacionesUsuarioDTO dto = new ListaNotificacionesUsuarioDTO();
                dto.setIdIncidencia(incidenciaLectura.getId());
                dto.setTituloIncidencia(incidenciaLectura.getDescripcion());
                dto.setId(notificacionLectura.getId());
                dto.setDescripcion(notificacionLectura.getDescripcion());
                dto.setFechaNotificacion(notificacionLectura.getFechaNotificacion());
                listaNotificacionesUsuarioDTOS.add(dto);
            }

            if (!listaNotificacionesUsuarioDTOS.isEmpty()){
                numeroNotificaciones = String.valueOf(listaNotificacionesUsuarioDTOS.size());
            }

        }
        return numeroNotificaciones;
    }



}