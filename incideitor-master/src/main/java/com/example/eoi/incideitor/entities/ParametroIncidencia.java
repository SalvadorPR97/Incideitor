package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ParametroIncidencia {
    @Id
    @OneToOne
    @JoinColumn(name = "incidencia_id", nullable = false)
    private Incidencia incidencia;
    private String nombre;
    private String valor;
}
