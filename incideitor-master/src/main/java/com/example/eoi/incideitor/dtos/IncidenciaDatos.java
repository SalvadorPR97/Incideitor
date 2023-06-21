package com.example.eoi.incideitor.dtos;

import com.example.eoi.incideitor.entities.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncidenciaDatos {
    private Long id;
    private String titulo;
    private String descripcion;
    private Estado estado;
    private LocalDate fecha;

}
