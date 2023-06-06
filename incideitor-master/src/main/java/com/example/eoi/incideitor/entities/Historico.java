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
@Table(name = "HISTORICOS")
public class Historico {


    @ManyToOne
    @JoinColumn(name = "incidencia_id")
    private Incidencia incidencia;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fechaCambioEstado")
    private Date fechaCambioEstado;


    private String mensajeAdicional;


}
