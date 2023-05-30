package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Votos {

// se ha añadido un id porque pedia una PK
    @Id
    @ManyToOne
    @JoinColumn(name = "incidencia_id")
    private Incidencia incidencia;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private boolean voto;
    private Date fecha;
}
