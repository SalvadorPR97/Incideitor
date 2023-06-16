package com.example.eoi.incideitor.services;

import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.Notificacion;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.NotificacionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;


    /**
     * Crea una nueva notificación y la guarda en la base de datos.
     *
     * @param incidencia Asigna la incidencia a la notificación.
     *
     * @param mensaje  El contenido del mensaje de la notificación.
     * @return La notificación creada y guardada.
     */
    public Notificacion crearNotificacion(Incidencia incidencia, String mensaje) {
        Notificacion notificacion = new Notificacion();
        notificacion.setFechaNotificacion(LocalDateTime.now());
        notificacion.setDescripcion(mensaje);
        notificacion.setIncidencia(incidencia);
        notificacionRepository.save(notificacion);
        return notificacion;
    }


}
