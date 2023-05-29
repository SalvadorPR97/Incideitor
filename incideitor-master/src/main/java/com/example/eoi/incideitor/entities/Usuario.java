package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String avatar;
    private String email;
    private String DNI;
    private String contraseña;
    private int sexo;

    @ManyToOne
    private Ayuntamiento ayuntamiento;

    @OneToMany
    private Collection<Reporte> reporte;

    private int permitirNotificaciones;

    @Value(value = "0")
    private int borradoLogico;
    private String departamento;
    private String extension;

}
