package com.example.eoi.incideitor.config;


import com.example.eoi.incideitor.controllers.UsuarioController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 *
 * <p>Para utilizar esta configuración en la aplicación, se debe anotar una clase de inicio con @SpringBootApplication y especificar
 * AppConfig como una de las clases de configuración.</p>
 */
@Configuration
public class AppConfig {

    @Autowired
    Environment environment;

    




}


