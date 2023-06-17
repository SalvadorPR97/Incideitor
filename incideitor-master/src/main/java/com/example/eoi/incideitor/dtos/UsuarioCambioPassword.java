package com.example.eoi.incideitor.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCambioPassword {

    private String usuario;

    private String contrasena;

    private String newcontrasena;
}
