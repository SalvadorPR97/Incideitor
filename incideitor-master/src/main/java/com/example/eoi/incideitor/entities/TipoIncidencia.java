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
@Table(name = "TIPOINCIDENCIA")
public class TipoIncidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String nombre;

    @Basic(optional = false)
    private boolean active;

    private Integer orden;

    @ManyToOne
    @JoinColumn(name = "incidencia_padre_id")
    private TipoIncidencia incidenciaPadre;
}