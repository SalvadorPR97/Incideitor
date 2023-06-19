package com.example.eoi.incideitor.controllers;


import com.example.eoi.incideitor.abstractcomponents.MiControladorGenerico;
import com.example.eoi.incideitor.dtos.*;
import com.example.eoi.incideitor.entities.Rol;
import com.example.eoi.incideitor.entities.Usuario;
import com.example.eoi.incideitor.entities.*;
import com.example.eoi.incideitor.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.example.eoi.incideitor.util.FileUploadUtil;
import com.example.eoi.incideitor.mapper.UsuarioMapper;
import com.example.eoi.incideitor.repositories.NotificacionRepository;
import com.example.eoi.incideitor.repositories.UsuarioRepository;
import com.example.eoi.incideitor.services.EmailService;
import com.example.eoi.incideitor.services.UsuarioService;
import com.example.eoi.incideitor.util.ObtenerDatosUsuario;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Autowired
    private ObtenerDatosUsuario obtenerDatosUsuario;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    EmailService emailService;

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
    }


    @GetMapping("/create")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "registro");
        return "index";
    }

    @PostMapping("/create")
    public String crearUsuario(@ModelAttribute Usuario usuario, @RequestParam(required = false) MultipartFile file) throws IOException {

        // Pone por defecto el Rol_Usuario a las nuevas cuentas
        Rol rol = new Rol();
        rol.setId(2);
        usuario.setRol(rol);

        // Hace que no se muestre la contraseña en el listado de usuarios
        String contrasena = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(contrasena);

        // Creamos el usuario para poder obtener el id
        service.create(usuario);

        //Guardamos la imagen
        String fileName = fileUploadUtil.uploadImgAvatar(file, usuario.getId());

        // Añadimos el nombre de la imagen al usuario
        usuario.setAvatar(fileName);
        // Y actualizamos el usuario
        service.update(usuario);

        //Generamos el contenido del email que vamos a enviar para darle la bienvenida
        Email emailRecPass = new Email();
        emailRecPass.setFrom("notificaciones@agestturnos.es");
        emailRecPass.setTo(usuario.getEmail());
        emailRecPass.setSubject("Confirmación de registro");
        emailRecPass.setContent("Muchas gracias por registrarte en nuestra aplicacion, "+usuario.getNombre());
        emailService.sendMail(emailRecPass);

        return "redirect:/";
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

    // Creamos el GetMapping que te va a redireccionar al html de login
    @GetMapping("/login")
    public String vistaLogin(){
        System.out.println("login");
        return "acceso/login";
    }


    @PostMapping("/login")
    public String validarPasswordPst(@ModelAttribute(name = "loginForm" ) LoginDto loginDto, Model model) {
        //Obtenemos el usuario y la contraseña respectivamente
        String usr = loginDto.getUsername();
        System.out.println("usr :" + usr);
        String password = loginDto.getPassword();
        System.out.println("pass :" + password);
        //Aqui buscamos en el repositorio un objeto Usuario que coincida con ese nombre de usuario y contraseña y pasamos
        // la contraseña por codificador para compararla con la version codificada de la BBDD.
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

    @GetMapping("/miperfil")
    public String miperfil(Model model) throws MiEntidadNoEncontradaException {
        try {
            Integer id = obtenerDatosUsuario.getUserData().getId();
            Usuario usuario = this.service.getById(id);
            UsuarioMiPerfil dto = usuarioMapper.toDtoMiPerfil(usuario);
            model.addAttribute("usuario", dto);
            model.addAttribute("entityName", entityName);
            model.addAttribute("nombreVista", "usuario-profile");
            return "index"; // Nombre de la plantilla para mostrar los detalles de una entidad

        } catch (MiEntidadNoEncontradaException ex) {
            return "error"; // Nombre de la plantilla para mostrar la página de error
        }
    }

    // Con mis dos funciones genero el token para el posterior cambio de contraseña

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    public  String cadenaAleatoria(int longitud) {
        // Los caracteres que queremos que tenga nuestro token
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    //URL PARA EL CAMBIO DE CONTRASEÑA

    @GetMapping("/olvidarPass")
    public String formResetPass(Model model){
        model.addAttribute("entityName", entityName);
        model.addAttribute("nombreVista", "recuperarPass");
        return "index";
    }

    @PostMapping("/olvidarPass")
    public String cambiopass(String email) throws Exception {
        //Busco mi usuario en la BBDD
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        //Instancio un objeto Usuario para posteriormente añadirle la información
        Usuario usuarioNuevoToken = new Usuario();

        //Generamos un token de 50 carácteres que se le añadirá al usuario encontrado para el cambio de contraseña
        String newtoken = this.cadenaAleatoria(50);
        if (usuario.isPresent()){
            //Añado los datos del usuario al objeto Usuario creado anteriormente y lo actualizo
            usuarioNuevoToken = usuario.get();
            usuarioNuevoToken.setToken(newtoken);
            usuarioService.update(usuarioNuevoToken);

            //Generamos el contenido del email que vamos a enviar para posibilitar el cambio de contraseña
            Email emailRecPass = new Email();
            emailRecPass.setFrom("notificaciones@agestturnos.es");
            emailRecPass.setTo(usuarioNuevoToken.getEmail());
            emailRecPass.setSubject("Cambio de contraseña");
            emailRecPass.setContent("localhost:8080/usuario/resetpass/"+newtoken);
            emailService.sendMail(emailRecPass);
            return "redirect:/";
        }else {
            //Mostrar página usuario no existe
            return "/error";
        }
    }

    // Ahora vamos a cambiar la contraseña con el nuevo token proporcionado
    @GetMapping("/resetpass/{token}")
    public String cambiopass(@PathVariable("token") String token, Model model) {
        //Buscamos al usuario en la BBDD por el token proporcionado
        Optional<Usuario> usuario = usuarioRepository.findByToken(token);

        //Creamos un dto con el usuario, la contraseña y la nueva contraseña
        UsuarioCambioPassword usuarioCambioPsw = new UsuarioCambioPassword();

        if (usuario.isPresent()){
            System.out.println("Cambio de contraseña para: "+usuario.get().getNombre() + ", con token: " + token );
            usuarioCambioPsw.setUsuario(usuario.get().getEmail());
            usuarioCambioPsw.setContrasena("******************");
            usuarioCambioPsw.setNewcontrasena("******************");
            model.addAttribute("datos", usuarioCambioPsw);
            model.addAttribute("entityName", entityName);
            model.addAttribute("nombreVista", "resetearpasswordlogin");
            return "index";
        }else {
            //Mostrar página usuario no existe
            return "/error";
        }
    }

    @PostMapping("/resetpass")
    public String guardarUsuario(@ModelAttribute UsuarioCambioPassword dto, HttpServletRequest request) throws Exception {

        //Si las password no coinciden a la pag de error
        if (dto.getContrasena().equals(dto.getNewcontrasena())){
            //Busco el usuario en la bbdd
            Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(dto.getUsuario());

            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();

                // Actualizo la contraseña después de codificarla
                usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));

                // Modifico el token de nuevo
                String tokenNuevo = this.cadenaAleatoria(40);
                usuario.setToken(tokenNuevo);

                // Guardo el usuario
                usuarioService.update(usuario);

                return "redirect:/";
            } else {
                // Mostrar página de error de usuario no existe
                return "error";
            }
        } else {
            //Mostrar página usuario no existe
            return "error";
        }

    }





}

