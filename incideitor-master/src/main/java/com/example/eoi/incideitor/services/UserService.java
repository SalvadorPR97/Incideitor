package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUserByID(Integer userId)
    {
        return usuarioRepository.findById(userId);
    }

    public List<Usuario> findAll()
    {
        return usuarioRepository.findAll();
    }



}
