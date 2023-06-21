package com.example.eoi.incideitor.services;

import com.example.eoi.incideitor.entities.Usuario;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuario usuario);
}
