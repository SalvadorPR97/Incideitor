package com.example.eoi.incideitor.websockets.controllers;

import com.example.eoi.incideitor.entities.Notificacion;
import com.example.eoi.incideitor.repositories.NotificacionRepository;
import com.example.eoi.incideitor.services.NotificacionService;
import com.example.eoi.incideitor.websockets.messages.PrivateMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import java.util.Optional;

@Controller
@Log4j2
@EnableWebSocketMessageBroker
public class STOMPMessageController {
    /**
     * The Simp messaging template.
     */
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    /**
     * Notificacion service.
     */
    @Autowired
    NotificacionService notificacionService;

    @Autowired
    NotificacionRepository notificacionRepository;

    @MessageMapping("/private")
    public void sendToSpecificIncidence(@Payload PrivateMessage message) {

        // Creo mi notificación en la base de datos para poder controlar el estado de los mensajes
        Notificacion notificacion = notificacionService.crearNotificacion(message.getIncidencia(), message.getText());
        // Cuando ya tenemos el ID de la notificación, lo informamos en nuestro objeto PrivateMessage creado ad-hoc
        message.setNotificationID(notificacion.getId());

        // Componemos un nuevo mensaje STOMP con nuestro PrivateMessage
        simpMessagingTemplate.convertAndSendToUser(
                String.valueOf(message.getIncidencia()),
                "/specific",
                message,
                createHeaders(message.getIncidencia().getTitulo(),
                        String.valueOf(notificacion.getId()))
        );
        log.info("Mensaje enviado a: " + message.getIncidencia());
        log.info("Notificación creada con ID: " + notificacion.getId());
    }

    /**
     * Crea los encabezados del mensaje con el destinatario y el ID de notificación.
     *
     * @param recipient      El destinatario del mensaje.
     * @param notificationID El ID de la notificación.
     * @return Los encabezados del mensaje.
     */
    private MessageHeaders createHeaders(String recipient, String notificationID) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.addNativeHeader("notificationID", notificationID);
        return headerAccessor.getMessageHeaders();
    }

    /**
     * Maneja la recepción de un mensaje privado.
     *
     * @param message El mensaje privado recibido.
     */
    @MessageMapping("/recibir")
    public void receiveMessage(@Payload PrivateMessage message) {
        Integer notificationId = message.getNotificationID();
        Optional<Notificacion> notificacion = notificacionRepository.findById(notificationId);

        if (notificacion.isPresent()) {
            notificacion.get().setEstado("READ");
            log.info("Notificación {} marcada como recibida", notificationId);
            notificacionRepository.save(notificacion.get());
        } else {
            log.error("No se encontró la notificación con ID: {}", notificationId);
        }
    }

}
