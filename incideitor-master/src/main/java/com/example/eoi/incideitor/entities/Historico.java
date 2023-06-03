package com.example.eoi.incideitor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class Historico {


    @OneToOne
    private Incidencia incidencia;

    @OneToOne
    private Estado estado;
    @Id
    private Date fechaCambioEstado;
    private String mensajeAdicional;


}
