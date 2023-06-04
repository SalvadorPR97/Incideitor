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

    @ManyToMany
    @JoinTable(
            name = "Incidencia_has_tiposIncidencias",
            joinColumns = @JoinColumn(name = "tipoIncidencia_id"),
            inverseJoinColumns = @JoinColumn(name = "incidencia_id"))
    private Collection<Incidencia> incidencias;
}
