package com.example.eoi.incideitor.websockets.messages;

import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrivateMessage {

    private Integer notificationID;

    private String text;

    private String estado;

    private Incidencia incidencia;



}
