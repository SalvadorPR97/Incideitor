package com.example.eoi.incideitor.util;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FileUploadUtil {

    //Método para guardar un archivo en una ubicación específica del sistema de archivos.
    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        //Se crea un objeto Path utilizando la direccion del directorio de subida proporcionada.
        Path uploadPath = Paths.get(uploadDir);

        //Comprobamos si el directorio de subida existe en el sistema de archivos. Si no existe, se crea utilizando el método createDirectories de la clase Files.
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        //Obtenemos un flujo de entrada mediante el objeto MultipartFile que contiene los datos del archivo
        try (InputStream inputStream = multipartFile.getInputStream()) {
            //Se crea un objeto Path que tendrá la ubicación completa del archivo
            Path filePath = uploadPath.resolve(fileName);
            //Se copian los datos del archivo desde el flujo de entrada al archivo en la ubicación especificada. Si ya existe en la ubicación se reemplaza el archivo.
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            //Si ocurre una excepción de tipo IOExcepcion lanzamos una una excepción con un mensaje de que no se pudo guardar la imagen
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

    //Método para subir imágenes de incidencias
    public List<String> uploadImgIncidencia(@RequestParam MultipartFile file, @RequestParam(required = false) MultipartFile file2, @RequestParam(required = false) MultipartFile file3, long id) throws IOException {
        //Se obtiene el nombre de archivo original,limpiando la ruta y dejando solo el nombre del archivo.
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //Asignamos el directorio de subida con la ruta relativa y el id de la incidencia
        String uploadDir = "src/main/resources/static/uploads/incidencia/"+id;

        //Invocamos el método saveFile para guardar el primer archivo en el directorio de subida
        FileUploadUtil.saveFile(uploadDir, fileName, file);

        //Creamos una lista vacia de nombres de archivos
        List<String> listaFileName = new ArrayList<>();

        //Se agrega el nombre del primer archivo a la lista de nombres de archivo
        listaFileName.add(fileName);

        //Si el segundo archivo no esta vacio obtenemos el nombre, se guarda en el directorio y lo agregamos a la lista
        if (!file2.isEmpty()){
            String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, fileName2, file2);
            listaFileName.add(fileName2);
        }

        //Si el tercer archivo no esta vacio obtenemos el nombre, se guarda en el directorio y lo agregamos a la lista
        if (!file3.isEmpty()){
            String fileName3 = StringUtils.cleanPath(file3.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, fileName3, file3);
            listaFileName.add(fileName3);

        }

        //Devolvemos la lista
        return listaFileName;
    }

    //Método para subir imagen de avatar
    public String uploadImgAvatar(@RequestParam MultipartFile file, Integer id) throws IOException {
        //Se obtiene el nombre de archivo original,limpiando la ruta y dejando solo el nombre del archivo.
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //Asignamos el directorio de subida con la ruta relativa y el id de la incidencia
        String uploadDir = "src/main/resources/static/uploads/avatar/"+id;
        //Invocamos el método saveFile para guardar el primer archivo en el directorio de subida
        FileUploadUtil.saveFile(uploadDir, fileName, file);

        //Devolvemos el nombre de archivo
        return fileName;
    }

    //Método que se encarga de listar los archivos en un directorio específico utilizando Java IO
    public Set<String> listFilesUsingJavaIO(String dir) {
        //Se crea un Set vacío para almacenar los nombres de archivo
        Set<String> strout = new HashSet<>();
        //Comprobar si hay archivos, si hay archivos los lista
        if ( HayArchivos(dir)){
            //Se utiliza un Stream para realizar las operaciones de listado
            strout = Stream.of(new File(dir).listFiles())
                    //Comprobamos que un archivo no sea un directorio
                    .filter(file -> !file.isDirectory())
                    //Se utiliza la función map para obtener los nombres de archivo de los objetos File restantes
                    .map(File::getName)
                    //Convertimos los nombres de archivo en un Set y los almacenamos en strout.
                    .collect(Collectors.toSet());
        }
        //Devolvemos strout
        return strout;
    }

    //Método para comprobar si hay archivos en un directorio específico
    public boolean HayArchivos(String dir) {
        //Se crea un objeto File utilizando la ruta del directorio proporcionada.
        File directory = new File(dir);
        //Si es un directorio, se procede a realizar la verificación adicional.
        if (directory.isDirectory()) {
            //Si la longitud del directorio es mayor que 0, significa que contiene archivos y devuelve true
            if (directory.length() > 0) {
                return true;
            } else {
                return false;
            }
        }
        //Si no contiene archivos devuelve false
        return false;
    }
}