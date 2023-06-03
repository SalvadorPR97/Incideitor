package com.example.eoi.incideitor.dtos;

import com.example.eoi.incideitor.entities.Incidencia;
import com.example.eoi.incideitor.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDTO {


    private Integer id;

    private int categoria;
    private String descripcion;
    private Incidencia incidencia;
    private Usuario usuario;

}
