package com.example.eoi.incideitor.configuration;


import com.example.eoi.incideitor.controllers.UsuarioController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Configuración de la aplicación.
 *
 * <p>Esta clase de configuración define los beans necesarios para la aplicación Spring.</p>
 *
 * <p>Los principios de programación de Spring que se aplican con esta configuración incluyen:</p>
 * <ul>
 *     <li>Inversión de control (IoC): Se utiliza la anotación @Autowired para aplicar la inyección de dependencias y obtener una
 *     instancia de Environment. Esto permite que los componentes dependientes, como el controlador, obtengan acceso a las propiedades
 *     y variables de entorno necesarias para su funcionamiento.</li>
 *     <li>Inyección de dependencias (DI): Se utiliza la anotación @Autowired para inyectar el Environment, lo que permite la separación
 *     de responsabilidades y mejora la mantenibilidad y la escalabilidad de la aplicación al no depender directamente de la creación y
 *     configuración del objeto.</li>
 * </ul>
 *
 * <p>En esta configuración se define el bean {@link UsuarioController} para manejar las solicitudes relacionadas con la entidad Usuario.
 * Se utiliza el constructor de la clase UsuarioController con el parámetro "usuario" para especificar el nombre de la entidad gestionada.</p>
 *
 * <p>Para utilizar esta configuración en la aplicación, se debe anotar una clase de inicio con @SpringBootApplication y especificar
 * AppConfig como una de las clases de configuración.</p>
 */
@Configuration
public class AppConfig {

    @Autowired
    Environment environment;

    




}


