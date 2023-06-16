package com.example.eoi.incideitor.dtos;

import com.example.eoi.incideitor.entities.Ayuntamiento;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioMiPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String avatar;
    private String email;
    private int sexo;
    private int permitirNotificaciones;

    private Ayuntamiento ayuntamiento;

}
