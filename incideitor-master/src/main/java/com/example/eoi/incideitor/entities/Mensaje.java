package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
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
@Table(name = "MENSAJES")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "mensaje")
    private Usuario usuarioEmisor;

    @OneToOne(mappedBy = "mensaje")
    private Usuario usuarioReceptor;

    private Date fecha;
    private String contenido;
    private Boolean leido;

}
