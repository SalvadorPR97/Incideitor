package com.example.eoi.incideitor.errorcontrol;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.exceptions.TemplateInputException;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para manejar los errores en la aplicación.
 *
 * <p>Esta clase implementa la interfaz ErrorController de Spring Boot para manejar los errores generados
 * durante la ejecución de la aplicación. Se encarga de mostrar una página de error personalizada
 * dependiendo del tipo de excepción ocurrida.</p>
 *
 * <p>Los principios de programación de Spring Boot y Java que se aplican en esta clase incluyen:</p>
 * <ul>
 *     <li>Inversión de Control (IoC): La clase utiliza la anotación @Autowired para inyectar la instancia
 *     del motor de plantillas TemplateEngine necesaria para procesar las plantillas HTML.</li>
 *     <li>Principio de Abstracción: La clase implementa la interfaz ErrorController, que es parte de la
 *     arquitectura de Spring Boot, proporcionando un contrato genérico para manejar los errores.</li>
 * </ul>
 *
 * @see org.springframework.boot.web.servlet.error.ErrorController
 */
@Controller
public class MyErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Autowired
    private TemplateEngine templateEngine;
    /**
     * Maneja los errores y muestra una página de error personalizada.
     *
     * @param request La solicitud HTTP que generó el error.
     * @param model   El modelo utilizado para pasar datos a la plantilla HTML.
     * @return El nombre de la plantilla HTML que muestra la página de error.
     * @Author Alejandro Teixeira Muñoz
     */
    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {

        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (HttpStatus.NOT_FOUND.value() == statusCode) {
            // Maneja el error de URL no encontrada
            model.addAttribute("error", "Url no encontrada");
            model.addAttribute("mensaje", "La página que buscas no está disponible en esta aplicación");
            return "/error";


        }
        else if(HttpStatus.FORBIDDEN.value()== statusCode){
            // Maneja el error de URL no encontrada
            model.addAttribute("error", "Acceso restringido");
            model.addAttribute("mensaje", "No tienes permitido el acceso a esta URL");
            return "/error";
        }
        {

            Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

            // Verificar si es una ServletException con una causa de Tem

            if (throwable instanceof ServletException && throwable.getCause() instanceof TemplateInputException) {
                ServletException servletException = (ServletException) throwable;
                TemplateInputException templateInputException = (TemplateInputException) servletException.getCause();

                // Obtener la lista de mensajes de las causas encadenadas
                List<String> causes = getCauseMessages(templateInputException);

                model.addAttribute("error", "Error en la carga de la plantilla");
                model.addAttribute("causas", causes);

                return "/error";
            }
            else {
                // Obtener la lista de mensajes de las causas encadenadas
                List<String> causes = getCauseMessages(throwable);

                // Maneja otros errores de manera genérica
                model.addAttribute("error", "Error desconocido");
                model.addAttribute("mensaje", "Se ha producido un error desconocido.");
                return "/error"; // Vista para el manejo genérico de errores

            }

        }

    }


    private List<String> getCauseMessages(Throwable throwable) {
        List<String> causes = new ArrayList<>();

        Throwable cause = throwable;
        while (cause != null) {
            if(!causes.contains(cause.getMessage()))
            {
                causes.add(cause.getMessage());
            }
            cause = cause.getCause();
        }

        return causes;
    }

}

