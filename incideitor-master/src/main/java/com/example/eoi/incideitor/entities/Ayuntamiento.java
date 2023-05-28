package com.example.eoi.incideitor.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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
    private Usuario usuario;

}
