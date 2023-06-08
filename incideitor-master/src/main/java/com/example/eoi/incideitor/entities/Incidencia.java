package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INCIDENCIAS")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ayuntamiento_id")
    private Ayuntamiento ayuntamiento;

    @OneToMany(mappedBy = "incidencia")
    private Collection<Historico> historicos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lugar_id",referencedColumnName = "id")
    private Lugar lugar;

    @OneToMany(mappedBy = "incidencia")
    private Collection<Foto> fotos;

    @OneToMany(mappedBy = "incidencia")
    private Collection<Notificacion> notificaciones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parametroIncidencia_id",referencedColumnName = "id")
    private ParametroIncidencia parametroIncidencia;

    @OneToMany(mappedBy = "incidencia")
    private Collection<Reporte> reportes;

    @OneToMany(mappedBy = "incidencia")
    private Collection<Voto> votos;

    //private int borradoLogico;

    @OneToOne(mappedBy = "incidencia")
    private Usuario idGestor;

    @ManyToOne
    @JoinColumn(name = "tipo_incidencia_id")
    private TipoIncidencia tipoIncidencia;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
}
