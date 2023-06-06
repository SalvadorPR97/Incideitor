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
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;
    private String avatar;
    private String email;
    private String dni;
    private String contrasena;
    private int sexo;

    @ManyToOne
    @JoinColumn(name = "ayuntamiento_id")
    private Ayuntamiento ayuntamiento;

    @OneToMany(mappedBy = "usuario")
    private Collection<Reporte> reportes;

    @OneToMany(mappedBy = "usuario")
    private Collection<Incidencia> incidencias;

    @Column(columnDefinition = "int default 0")
    private int permitirNotificaciones;

    @Column(columnDefinition = "int default 0")
    private int borradoLogico;

    private String departamento;
    private String extension;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mensaje_emisor_id",referencedColumnName = "id")
    private Mensaje mensaje_emisor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mensaje_receptor_id",referencedColumnName = "id")
    private Mensaje mensaje_receptor;

    @ManyToMany(mappedBy = "usuariosRol", fetch = FetchType.EAGER)

    private Collection<Rol> roles;

    @OneToMany(mappedBy = "usuario")
    private Collection<Voto> votos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "incidencia_id",referencedColumnName = "id")
    private Incidencia incidencia;


}
