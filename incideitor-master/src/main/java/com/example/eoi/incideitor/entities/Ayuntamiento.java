package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ayuntamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String fotoCabecera;
    private String fotoLogin;
    private String foto3;
    private String foto4;

    @OneToMany
    private Collection<Usuario> usuario;

}
