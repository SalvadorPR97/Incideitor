package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TipoIncidencia {

    @Id
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "PadreIncidencia_id", nullable = false)
    private TipoIncidencia padreIncidencia;
}
