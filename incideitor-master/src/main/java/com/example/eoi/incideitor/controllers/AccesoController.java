package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.dtos.LoginDto;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import com.example.eoi.incideitor.services.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

/**
 * Controlador para la gestión de acceso y autenticación.
 */
@Controller
@RequestMapping("${url.acceso}")
public class AccesoController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final String entityName = "acceso";

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Constructor de la clase AccesoController.
     * Se utiliza para crear una instancia del controlador.
     */
    public AccesoController() {
        super();
    }

    /**
     * Muestra la vista de inicio de sesión.
     *
     * @param model El modelo de datos para la vista.
     * @return El nombre de la plantilla de la vista.
     */
    @GetMapping("/login")
    public String vistaLogin(Model model) {
        model.addAttribute("usuariodto", new LoginDto());
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "login");
        return "index";
    }

    /**
     * Valida la contraseña ingresada en el formulario de inicio de sesión.
     *
     * @param loginDto El objeto de transferencia de datos con los datos del formulario.
     * @return El nombre de la plantilla de la vista a mostrar.
     */
    @PostMapping("/login")
    public String validarPasswordPst(@ModelAttribute(name = "loginForm") LoginDto loginDto) {
        String usr = loginDto.getUsername();
        String password = loginDto.getPassword();
        // ¿Es correcta la contraseña?
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmailAndContrasena(loginDto.getUsername(),
                passwordEncoder.encode(loginDto.getPassword()));
        if (usuarioOptional.isPresent()) {
            return "index";
        } else {
            return "acceso/login";
        }
    }

    /**
     * Muestra la vista de acceso denegado.
     *
     * @param model El modelo de datos para la vista.
     * @return El nombre de la plantilla de la vista.
     */
    @GetMapping("/accessDenied")
    public String AccesoDenegado(Model model) {
        return "/accessDenied";
    }

    /**
     * Realiza el proceso de cierre de sesión del usuario.
     *
     * @param request  La solicitud HTTP actual.
     * @param response La respuesta HTTP actual.
     * @return El nombre de la plantilla de la vista a mostrar después del cierre de sesión.
     * @throws ServletException Si se produce un error durante el proceso de cierre de sesión.
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        // Obtenemos la autenticación actualmente activa en el contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Verificamos si hay una autenticación válida
        if (authentication != null) {
            // Creamos un objeto SecurityContextLogoutHandler para cerrar la sesión
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        // Redirigimos a la página de inicio
        return "redirect:/";
    }
}

