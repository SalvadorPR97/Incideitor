package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TIPOS_INCIDENCIA")
public class TipoIncidencia {

    @Id
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "PadreIncidencia_id", nullable = false)
    private TipoIncidencia padreIncidencia;

    @OneToMany(mappedBy = "padreIncidencia")
    private Collection<TipoIncidencia> tiposIncidencia;

    @ManyToMany(mappedBy = "tiposIncidencia")
    private Collection<Incidencia> incidencias;
}
