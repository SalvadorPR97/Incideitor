package com.example.eoi.incideitor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    //El Id esta puesto porque no me dejaba crearlo sin Id pero en el modelo no tiene primary key
    @Id
    @OneToOne
    private Incidencia incidencia;
    @Id
    @OneToOne
    private Estados estado;
    @Id
    private Date fechaCambioEstado;
    private String mensajeAdicional;


}
