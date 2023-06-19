package com.example.eoi.incideitor.dtos;

import com.example.eoi.incideitor.entities.Ayuntamiento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDatosPrivadosAyuntamiento {

    private Integer id;

    private String nombre;
    private String apellido;
    private String avatar;
    private String email;
    private String dni;
    private String sexo;
    private Ayuntamiento ayuntamiento;

    private int permitirNotificaciones;


}
