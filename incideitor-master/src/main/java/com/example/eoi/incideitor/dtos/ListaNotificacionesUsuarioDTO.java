package com.example.eoi.incideitor.dtos;

import com.example.eoi.incideitor.entities.Incidencia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListaNotificacionesUsuarioDTO {

    private Integer id;
    private String descripcion;
    private Long idIncidencia;
    private String tituloIncidencia;
    private LocalDateTime fechaNotificacion;

}
