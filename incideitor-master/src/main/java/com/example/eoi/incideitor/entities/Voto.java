package com.example.eoi.incideitor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Voto {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Integer id;

    @ManyToOne
    @JoinTable(name="votos_incidencia")
    private Incidencia incidencia;

    @ManyToOne
    @JoinTable(name="votos_usuarios")
    private Usuario usuario;

    private Boolean voto;
    private Date fecha;
}
