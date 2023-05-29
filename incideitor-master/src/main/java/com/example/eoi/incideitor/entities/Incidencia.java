package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descripcion;
    private Date fecha;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Ayuntamiento ayuntamiento;


}
