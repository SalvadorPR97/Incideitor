package com.example.eoi.incideitor.services;

import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.Notificacion;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.NotificacionRepository;
import com.example.eoi.incideitor.websockets.messages.PrivateMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;


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
        notificacion.setEstado("Pendiente");
        notificacion.setFecha_notificacion(LocalDateTime.now());
        notificacion.setDescripcion(mensaje);
        notificacion.setIncidencia(incidencia);
        notificacionRepository.save(notificacion);
        return notificacion;
    }


    public void crearMensajeYNotificacionDeAdminCuandoOcurreAlgoYEnviarElMensaje(String descripcion, Incidencia incidencia) {
        // Primero creamos la notificación de algo que ocurre en el sistema
        Notificacion notificacion = crearNotificacion(incidencia, descripcion);

        // Después preparamos el objeto mensaje que será enviado por la cola de mensajes STOMP en base a la
        // notificación de que ha ocurrido algo
        // El mensaje toma el ID de la notificación que hemos creado en BD para controlar su recepción cuando un
        // cliente conectado lo recibe.
        PrivateMessage privateMessage = new PrivateMessage(
                notificacion.getId(),
                notificacion.getDescripcion(),
                notificacion.getEstado(),
                notificacion.getIncidencia()
        );

        enviarMensajePrivado(privateMessage);
    }

    /**
     * Envía un mensaje privado a través de la cola de mensajes STOMP.
     *
     * @param privateMessage El mensaje privado a enviar.
     */
    public void enviarMensajePrivado(PrivateMessage privateMessage) {
        simpMessagingTemplate.convertAndSendToUser(
                privateMessage.getIncidencia().getTitulo(),
                "/specific",
                privateMessage,
                createHeaders(privateMessage.getIncidencia().getTitulo(), String.valueOf(privateMessage.getNotificationID()))
        );
        log.info("Mensaje enviado a: " + privateMessage.getIncidencia());
    }

    /**
     * Crea los encabezados del mensaje con el destinatario y el ID de notificación.
     *
     * @param recipient      El destinatario del mensaje.
     * @param notificationID El ID de la notificación.
     * @return Los encabezados del mensaje.
     */
    public MessageHeaders createHeaders(String recipient, String notificationID) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.addNativeHeader("notificationID", notificationID);
        return headerAccessor.getMessageHeaders();
    }

}
