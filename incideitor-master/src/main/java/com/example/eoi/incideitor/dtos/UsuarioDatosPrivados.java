package com.example.eoi.incideitor.dtos;

import com.example.eoi.incideitor.entities.Ayuntamiento;
import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.Reporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDatosPrivados {

    private Integer id;

    private String nombre;
    private String apellido;
    private String avatar;
    private String email;
    private String dni;
    private int sexo;

    private int permitirNotificaciones;


}
