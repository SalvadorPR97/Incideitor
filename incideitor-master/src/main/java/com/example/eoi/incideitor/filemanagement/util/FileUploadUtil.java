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

    public void uploadImgPost(@RequestParam MultipartFile file, HttpSession session , Model model, long id) throws IOException {
        String path=session.getServletContext().getRealPath("/");
        String filename=file.getOriginalFilename();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "src/main/resources/static/uploads/"+id;

        FileUploadUtil.saveFile(uploadDir, fileName, file);

        model.addAttribute("file",file);
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