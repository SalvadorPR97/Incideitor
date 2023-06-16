package com.example.eoi.incideitor.filemanagement.util;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
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

    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

    public List<String> uploadImgIncidencia(@RequestParam MultipartFile file, @RequestParam(required = false) MultipartFile file2, @RequestParam(required = false) MultipartFile file3, long id) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "src/main/resources/static/uploads/incidencia/"+id;
        FileUploadUtil.saveFile(uploadDir, fileName, file);

        List<String> listaFileName = new ArrayList<>();
        listaFileName.add(fileName);

        if (!file2.isEmpty()){
            String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, fileName2, file2);
            listaFileName.add(fileName2);
        }

        if (!file3.isEmpty()){
            String fileName3 = StringUtils.cleanPath(file3.getOriginalFilename());
            FileUploadUtil.saveFile(uploadDir, fileName3, file3);
            listaFileName.add(fileName3);

        }


        return listaFileName;
    }

    public String uploadImgAvatar(@RequestParam MultipartFile file, Integer id) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        String uploadDir = "src/main/resources/static/uploads/avatar/"+id;

        FileUploadUtil.saveFile(uploadDir, fileName, file);

        return fileName;
    }

    public Set<String> listFilesUsingJavaIO(String dir) {
        //Comprobar si hay archivos
        Set<String> strout = new HashSet<>();
        if ( HayArchivos(dir)){
            strout = Stream.of(new File(dir).listFiles())
                    .filter(file -> !file.isDirectory())
                    .map(File::getName)
                    .collect(Collectors.toSet());
        }
        return strout;
    }
    public boolean HayArchivos(String dir) {
        File directory = new File(dir);
        if (directory.isDirectory()) {
            if (directory.length() > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}