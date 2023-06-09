package com.example.eoi.incideitor.filemanagement.controllers;


import com.example.eoi.incideitor.filemanagement.util.FileUploadUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SessionAttributes("incidencias")
@Controller
public class AppUploadController {


    public AppUploadController() {
        super();
    }

    @GetMapping("/uploadimg")
    public String vistaGetImg( ){
        return "incidencia/registro";
    }

    public void uploadImgPost(@RequestParam MultipartFile file, HttpSession session , Model model, long id) throws IOException {
        String path=session.getServletContext().getRealPath("/");
        String filename=file.getOriginalFilename();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "src/main/resources/static/uploads/"+id;

        FileUploadUtil.saveFile(uploadDir, fileName, file);

        model.addAttribute("file",file);
    }


}
