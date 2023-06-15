package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.dtos.LoginDto;
import com.example.eoi.incideitor.dtos.UsuarioDatosPrivados;
import com.example.eoi.incideitor.entities.Rol;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import com.example.eoi.incideitor.services.UsuarioService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("${url.usuario}")
public class UsuarioController extends MiControladorGenerico<Usuario> {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Value("${url.usuario}")
    private String url;

    private String entityName = "usuario";

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Constructor de la clase UsuarioController.
     * Se utiliza para crear una instancia del controlador.
     */
    public UsuarioController() {
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
    @PostConstruct
    private void init() {
        super.entityName = entityName;
        super.url = url;
    }


    @GetMapping("/create")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "registro");
        return "index";
    }

    @PostMapping("/create")
    public String crearUsuario(@ModelAttribute Usuario usuario) {

        // Pone por defecto el Rol_Usuario a las nuevas cuentas
        Rol rol = new Rol();
        rol.setId(2);
        usuario.setRol(rol);

        // Hace que no se muestre la contraseña en el listado de usuarios
        String contrasena = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(contrasena);

        service.create(usuario);
        return "redirect:/usuario/admin";
    }

    @GetMapping("/edit/{id}")
    public String editDto(@PathVariable Object id,  Model model) throws MiEntidadNoEncontradaException {
        try {

            Usuario usuario = service.getById(id);
            UsuarioDatosPrivados dto = this.usuarioService.leerUsuarioPrivado(usuario.getId());
            model.addAttribute("entity", dto);
            model.addAttribute("entityName", entityName);
            model.addAttribute("nombreVista", "entity-details");
            return "index"; // Nombre de la plantilla para mostrar los detalles de una entidad

        } catch (MiEntidadNoEncontradaException ex) {
            return "error"; // Nombre de la plantilla para mostrar la página de error
        }
    }

    @PostMapping("/edit/{id}")
    public String saveDto (@ModelAttribute UsuarioDatosPrivados dto){
        this.usuarioService.guardarUsuarioDatosPrivados(dto);
        return "redirect:/" + entityName + "/admin";

    }


    @GetMapping("/login")
    public String vistaLogin(){
        System.out.println("login");
        return "acceso/login";
    }
    @PostMapping("/login")
    public String validarPasswordPst(@ModelAttribute(name = "loginForm" ) LoginDto loginDto, Model model) {
        String usr = loginDto.getUsername();
        System.out.println("usr :" + usr);
        String password = loginDto.getPassword();
        System.out.println("pass :" + password);
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmailAndContrasena(loginDto.getUsername(),
                passwordEncoder.encode(loginDto.getPassword()));
        //¿es correcta la password?
        if (usuarioOptional.isPresent())
        {
            model.addAttribute("entityName", "home");
            model.addAttribute("nombreVista", "principal");
            return "index";
        }else {
            return "redirect:/acceso/login";
        }
    }

    @GetMapping("logic/{id}")
    public String borradoLogico(@PathVariable Object id , Model model) {
        Usuario usuario = service.getById(id);
        if (usuario.getBorradoLogico() == 0){
            usuario.setBorradoLogico(1);
        } else {
            usuario.setBorradoLogico(0);
        }
        service.update(usuario);
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "admin");
        return "redirect:/" + entityName + "/admin"; // Redireccionar a la página de listar todas las entidades después de eliminar una entidad
    }

}

