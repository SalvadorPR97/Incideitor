# Incideitor

Aplicación web diseñada para facilitar la gestión de incidencias relacionadas con los ayuntamientos.

## Modo de empleo:
1º. En la declaración de "google.maps.api.key=" en "application.properties" hay que 
introducir una API KEY de google maps.

2º. Para usar la aplicación necesitará el jdk 20 y Docker instalado. Primero 
abre docker desktop, después ve a la línea de comandos e introduce:
*$ docker compose up -d*. Ejecutar la aplicación desde el IDE.




### Registro
Es muy sencillo registrarse ya que cuando intente entrar en cualquier 
zona que necesite loguearse esta aplicación lo deriva al login, el cual tiene
un apartado para el registro. 

>Una vez ya registrado automáticamente se le 
enviará un correo confirmando que ya está registrado. 

Ya está logueado y podrá acceder donde sus credenciales 
(de forma predeterminada de Usuario) le permitan en la página.

### Recuperar contraseña
Solo acccede al login y entra en la opción _¿Ha olvidado la contraseña?_.
Se envía un email al correo para que pueda restablecer la contraseña. 

### Crear incidencia
Crear una incidencia es muy sencillo. Al estar logueado podrá ver en el 
navbar de la aplicación **Nueva Incidencia**, acceda y rellene el formulario 
en el que para la incidencia la cual se autocompleta con **_Google Maps_**.

### Reportes **_(Work In Progress)_**
Está diseñado para soportar reportes de incidencias y bugs, pero no está 
implementado todavía.

### Control de incidencias
Mediante el rol de Administrador podemos modificar o eliminar cualquier 
incidencia. Este rol se crea modificando la base de datos. Al entrar en 
la lista de incidencia y de usuarios podemos gestionar ambos ya sea editando
o eliminándolos.

## Estructura

Esta aplicación está basado en el Modelo Vista Controlador MVC.
Se divide en funcionalidades:
- La carpeta **_JAVA_** están los metadatos del paquete.
- La carpeta **_Resources_** Configuración y pantallas.
-  **_Otros Archivos_** de configuración.

### JAVA

Esta carpeta se divide en las siguientes funcionalidades:

- abstractComponents
  - > Controladores y servicios genéricos para Spring
- confing
  - >  Configuración de la App, del Modelo Vista controlador y de seguridad.
- controllers
  - > Controladores de las distintas entidades.
- dtos
  - > Data Transfer Objet.
- entities
  - > Las diferentes clases o tablas utilizadas.
- errorcontrol
  - > Controlador de errores y excepciones.
- mapper
  - > Sirve para cambiar de DTO a entidad y viceversa
- repositories
  - > Interfaz que es un intermediario entre la Base de Datos y la aplicación.
- services
  - > Métodos específicos usados en los controladores.
- util
  - > Clases comodín en las que se reúnen métodos comunes.

### Resources

Esta carpeta se divide en las siguientes funcionalidades:

- **static**
  - > Localización en la que se encuentra carpetas relacionadas con 
la configuración e imágenes del Front para la vista de pantallas de 
la palicación. 
- **templates**
  - > Pantallas de la aplicación separadas por funcionalidad. 
- **aplication.properties**
  - > Configuración de direcciones url y del envío de mails.
- **application.yml**
  - > Configuración para la conexión de spring con MySQL.
- **application-desarrollo.yml**
  - > Configuración para la conexión de spring con Hibernate y la app.
- **data.sql**
  - > Iniciación de los datos de MySQL.
- **Resources Bundle 'messages'**
  - > Carpeta para la traducción del programa.
### Otros archivos

Estos archivos se encuentran en la raíz del programa y son
sobre todo de la configuración inicial de la aplicación.

- **.env**
   - > Configuración de base de datos.   
- **gitignore**
  - > Archivos ignorados por git.
- **docker-compose.yml**
  - > Configuración del Docker para la creación de la imagen 
- **Dockerfile**
  - > Variables del .env para la configuración de Docker y la Base de Datos
- **mnvn.cmd**
  - > Archivo de configuración de Maven 
- **pom.xml**
  - > Dependencias y plugins de Maven 
- **README.md**
  - > Documento con la información del programa








