package com.example.eoi.incideitor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Votos {
    //El Id esta puesto porque no me dejaba crearlo sin Id pero en el modelo no tiene primary key
    @Id
    private Integer id;
    @ManyToOne
    private Incidencia incidencia;
    @ManyToOne
    private Usuario usuario;
    private Boolean voto;
    private Date fecha;
}
