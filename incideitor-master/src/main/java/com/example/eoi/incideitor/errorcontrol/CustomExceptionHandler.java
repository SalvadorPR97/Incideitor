package com.example.eoi.incideitor.errorcontrol;

import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.ejemplospringboot.errorcontrol.exceptions.ParametrosIncorrectosException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.webjars.NotFoundException;

/**
 * Manejador de excepciones personalizado para la aplicación.
 *
 * <p>Esta clase se encarga de manejar las excepciones lanzadas durante la ejecución de la aplicación y proporcionar una respuesta de error
 * adecuada. Utiliza la anotación {@link ControllerAdvice} para capturar las excepciones y definir los métodos de manejo correspondientes.</p>
 *
 * <p>Los principales componentes de esta clase son:</p>
 * <ul>
 *     <li>Métodos de manejo de excepciones: Se definen métodos anotados con {@link ExceptionHandler} para manejar excepciones específicas.
 *     Cada método de manejo recibe la excepción lanzada y el objeto Model, y devuelve el nombre de la plantilla de error que se mostrará al
 *     usuario. Dentro de estos métodos, se configuran los atributos necesarios en el objeto Model para proporcionar información sobre el
 *     error ocurrido.</li>
 *     <li>Clase ErrorResponse: Se define una clase interna {@link ErrorResponse} para representar la respuesta de error. Esta clase tiene
 *     atributos para el mensaje de error y detalles adicionales que pueden ser utilizados para proporcionar información más específica sobre
 *     el error.</li>
 * </ul>
 *
 * <p>Esta clase sigue los principios de programación de Spring que se aplican a los controladores y al manejo de excepciones, incluyendo:</p>
 * <ul>
 *     <li>Inversión de control (IoC): La clase utiliza la anotación @ControllerAdvice para aplicar la inversión de control y capturar las
 *     excepciones lanzadas en la aplicación. Además, utiliza la anotación @Autowired para inyectar el objeto Model en los métodos de manejo
 *     de excepciones.</li>
 *     <li>Inyección de dependencias (DI): La clase utiliza la anotación @Autowired para inyectar el objeto Model en los métodos de manejo
 *     de excepciones. Esto permite la separación de responsabilidades y mejora la mantenibilidad y la escalabilidad del código.</li>
 *     <li>Manejo de excepciones: La clase define métodos de manejo de excepciones específicas mediante la anotación @ExceptionHandler.
 *     Estos métodos proporcionan una lógica personalizada para manejar cada tipo de excepción lanzada y retornan el nombre de la plantilla
 *     de error correspondiente.</li>
 * </ul>
 * @Author Alejandro Teixeira Muñoz
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private static final String errorMessageFieldName = "mensaje";
    private static final String errorErrorDescriptionFieldName = "error";
    private static final String errorCausaFieldName = "causa";

    /**
     * Maneja la excepción EntityNotFoundException.
     *
     * @param ex    La excepción EntityNotFoundException lanzada.
     * @param model El objeto Model para agregar los atributos necesarios.
     * @return El nombre de la plantilla de error.
     * @Author Alejandro Teixeira Muñoz
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public String handleEntityNotFoundException(EntityNotFoundException ex, Model model) {
        model.addAttribute(errorErrorDescriptionFieldName, "Entidad no localizada");
        model.addAttribute(errorMessageFieldName, ex.getLocalizedMessage());
        model.addAttribute(errorCausaFieldName, ex.getCause());
        return "error";
    }



    /**
     * Maneja la excepción MiEntidadNoEncontradaException.
     *
     * @param ex    La excepción MiEntidadNoEncontradaException lanzada.
     * @param model El objeto Model para agregar los atributos necesarios.
     * @return El nombre de la plantilla de error.
     * @Author Alejandro Teixeira Muñoz
     */
    @ExceptionHandler(MiEntidadNoEncontradaException.class)
    public String handleMiEntidadNoEncontradaException(MiEntidadNoEncontradaException ex, Model model) {
        model.addAttribute(errorErrorDescriptionFieldName, "Entidad DETERMINADA no localizada");
        model.addAttribute(errorMessageFieldName, ex.getLocalizedMessage());
        model.addAttribute(errorCausaFieldName, ex.getCause());
        return "error";
    }


    /**
     * Maneja la excepción ParametrosIncorrectosException.
     *
     * @param ex    La excepción ParametrosIncorrectosException lanzada.
     * @param model El objeto Model para agregar los atributos necesarios.
     * @return El nombre de la plantilla de error.
     */
    @ExceptionHandler(ParametrosIncorrectosException.class)
    public String handleParametrosIncorrectosException(ParametrosIncorrectosException ex, Model model) {
        model.addAttribute(errorErrorDescriptionFieldName, "Los parámetros son incorrectos");
        model.addAttribute(errorMessageFieldName, ex.getLocalizedMessage());
        model.addAttribute(errorCausaFieldName, ex.getCause());
        return "error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundError(Model model) {
        // Personaliza la lógica y los atributos del modelo para la respuesta de error 404
        model.addAttribute("error", "Página no encontrada");
        model.addAttribute("mensaje", "La página que buscas no está disponible.");

        return "error";
    }

    @ExceptionHandler(Throwable.class)
    public String handleGlobalException(Throwable throwable) {
        if (throwable instanceof NotFoundException) {
            throw (NotFoundException) throwable; // Relanza la excepción NotFoundException para que sea manejada por CustomErrorController
        } else {
            // Maneja otras excepciones de manera genérica
            throw new RuntimeException("Error desconocido");
        }
    }


    /**
     * Maneja excepciones no controladas.
     *
     * @param ex    La excepción no controlada lanzada.
     * @param model El objeto Model para agregar los atributos necesarios.
     * @return El nombre de la plantilla de error.
     * @Author Alejandro Teixeira Muñoz
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute(errorErrorDescriptionFieldName, ex.getLocalizedMessage());
        model.addAttribute(errorCausaFieldName, ex.getCause());
        return "error";
    }


    /**
     * Clase ErrorResponse para representar la respuesta de error.
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class ErrorResponse {
        // Atributos para el mensaje de error, código de estado, detalles, etc.
        private String error;
        private String causa;

    }

}


