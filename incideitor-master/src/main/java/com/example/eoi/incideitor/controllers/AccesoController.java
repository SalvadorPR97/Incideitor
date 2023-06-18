package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.dtos.LoginDto;
import com.example.eoi.incideitor.dtos.UsuarioDatosPrivados;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import com.example.eoi.incideitor.services.UsuarioService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

/**
 * Controlador para la entidad Usuario.
 *
 * <p>Esta clase se encarga de manejar las solicitudes relacionadas con la entidad Usuario utilizando la funcionalidad proporcionada por
 * la clase {@link MiControladorGenerico}.</p>
 *
 * <p>Los principales componentes de esta clase son:</p>
 * <ul>
 *     <li>Inversión de control (IoC): La clase extiende MiControladorGenerico y utiliza la funcionalidad proporcionada por ella.
 *     Esto permite que los detalles de implementación sean proporcionados por la clase genérica y facilita la reutilización de código
 *     y la consistencia en la implementación de controladores.</li>
 *     <li>Inyección de dependencias (DI): La clase utiliza inyección de dependencias para obtener el nombre de la entidad gestionada.
 *     El valor de entityName se inyecta utilizando la anotación @Value en la propiedad correspondiente. Esto permite la separación de
 *     responsabilidades y mejora la mantenibilidad y escalabilidad del controlador.</li>
 *     <li>Principio de abstracción: La clase extiende la clase genérica MiControladorGenerico, lo que permite una implementación
 *     común de las operaciones CRUD para la entidad Usuario. Esto facilita la reutilización de código y mejora la consistencia en
 *     la implementación de controladores.</li>
 * </ul>
 *
 * "@param <Usuario>" El tipo de entidad gestionada por el controlador.
 * "@Author Alejandro Teixeira Muñoz
 */
@Controller
@RequestMapping("acceso")
public class AccesoController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Value("acceso")
    private String url;

    private String entityName = "acceso";

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Constructor de la clase UsuarioController.
     * Se utiliza para crear una instancia del controlador.
     */
    public AccesoController() {
        super();
    }

    /**
     * Método de inicialización para establecer el valor de entityName y entityPrefix.
     * El valor de entityName se obtiene de una propiedad configurada en un archivo de propiedades utilizando la anotación @Value.
     * Después de la construcción del objeto UsuarioController, se llama a este método para establecer los valores necesarios.
     *
     * @PostConstruct indica que este método debe ejecutarse después de que se haya construido el objeto UsuarioController.
     * Es una anotación de JSR-250 y se utiliza para realizar tareas de inicialización una vez que todas las dependencias hayan sido inyectadas.
     * En este caso, se utiliza para asegurar que entityName y entityPrefix se establezcan correctamente después de la construcción del objeto.
     * @Author Alejandro Teixeira Muñoz
     */


    @GetMapping("/login")
    public String vistaLogin(Model model){
        model.addAttribute("usuariodto", new LoginDto());
        model.addAttribute("entityName", "acceso");
        model.addAttribute("nombreVista", "login");
        return "index";
    }
    @PostMapping("/login")
    public String validarPasswordPst(@ModelAttribute(name = "loginForm" ) LoginDto loginDto) {
        String usr = loginDto.getUsername();
        System.out.println("usr :" + usr);
        String password = loginDto.getPassword();
        System.out.println("pass :" + password);
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmailAndContrasena(loginDto.getUsername(),
                passwordEncoder.encode(loginDto.getPassword()));
        //¿es correcta la password?
        if (usuarioOptional.isPresent())
        {
            return "index";
        }else {
            return "acceso/login";
        }
    }
    // Crear el accessDenied
    @GetMapping("/accessDenied")
    public String AccesoDenegado(Model model){

        return "/accessDenied";
    }

    //Metodo para hacer Logout
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        // Obtenemos la autenticación actualmente activa en el contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Verificamos si hay una autenticación válida
        if (authentication != null) {
            // Creamos un objeto SecurityContextLogoutHandler para cerrar sesion
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        // Redirigimos a la página de inicio
        return "redirect:/";
    }


}

