# Incideitor

Aplicación web diseñada para facilitar la gestión de incidencias relacionadas con los ayuntamientos.

## Modo de empleo:
Al ser una aplicación web no necetita instalación previa, 
solo la url del ayuntamiento el cual decidada contar con los servicios 
de Incideitor.
Una vez se encuentre en la página tendrá un acceso limitado mientras no
se registre en la misma.

### Registro
Es muy sencillo registrarse ya que cuando intente entrar en cualquier 
zona que necesite loguearse esta aplicación lo deriva al login, el cual tiene
un apartado para el registro. 

>Una vez ya registrado automáticamente se le 
enviará un correo confirmando que ya está registrado. 

Ya esta
logueado y podrá acceder donde sus credenciales (de forma prederteminada 
de Usuario) le permitan en la página.

### Recuperar contraseña
Solo acccede al login y entra en la opción  _¿Ha olvidado la contraseña?_.
Se envía un email al correo para que pueda restablecer la contraseña. 

### Crear incidencia
Crear una incidencia es muy sencillo. Al estar logueado podrá ver en el 
navbar de la aplicación **Nueva Incidencia**, acceda y rellene el formulario 
en el que para la incidencia la cual se auto completa con **_Google Maps_**.

### Reportes **_(Work In Progress)_**
Está diseñado para soportar reportes de incidencias y bugs pero no está 
implementado.

### Control de incidencias
Mediante el rol de Administrador podemos modificar o eliminar cualquier 
incidencia. Este rol se crea modificando la base de datos. Al entrar en 
la lista de incidencia y de usuarios podemos gestionar ambos ya sea editando
o eliminandolos.

## Estructura

Esta aplicación está basado en el Modelo Vista Controlador MVC.
Se divide en funcionalidades:
- La carpeta **_JAVA_** estan los metadatos del paquete.
- La carpeta **_Resources_** Configuración y pantallas.
-  **_Otros Archivos_** de configuarción.

### JAVA

Esta carpeta se divide en las siguentes funcionalidades:

- abstractComponents
- confing
- controllers
- dtos
- entities
- errorcontrol
- mapper
- repositories
- services
- util

### Resources

Esta carpeta se divide en las siguentes funcionalidades:

- static
- templates
- aplication.properties
- application.yml
- application-desarrollo.yml
- data.sql
- Resources Bundle 'messages'

### Otros archivos

Estos archivos se encuentran en la raiz del programa y son
sobre todo de la configuración inicial de la aplicación.

- .env
- gitignore
- docker-compose.yml
- Dockerfile
- mnvn.cmd
- pom.xml
- README.md







