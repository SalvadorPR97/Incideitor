/**
 * 
 */
package com.example.eoi.incideitor.controllers;



import com.example.eoi.incideitor.dtos.Email;
import com.example.eoi.incideitor.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppSendMailController {
	EmailService service;

	@Autowired
	private JavaMailSender sender;

	protected AppSendMailController(EmailService service) {
		super();
		this.service = service;
	}

	@GetMapping("/email/emailsimpleusr")
	public String getSendMailUsr(Model interfazConPantalla){
		Email email = new Email();
		String resultadoenvio = "";
		interfazConPantalla.addAttribute("email", email);
		interfazConPantalla.addAttribute("resultado", resultadoenvio);
		return "email/emailsimpleusr";
	}

	@PostMapping("/email/emailsimpleusr")
	public String postSendMailUsr(@ModelAttribute(name ="email") Email email,Model interfazConPantalla) {
		String resultadoenvio = "";
		System.out.println("emailsimple en el post; " + email.getContent());
		try {
			service.sendMail(email);
			System.out.println("emailsimple enviado");
			resultadoenvio = "Envío correcto";
		} catch (Exception e){
			System.out.println("emailsimple error envío");
			resultadoenvio = "Error envío:" + e;
		}
		interfazConPantalla.addAttribute("resultado", resultadoenvio);
		interfazConPantalla.addAttribute("email", email);
		return "email/emailsimple";
	}
	@GetMapping("/email/emailsimple")
	public String getSendMail(Model interfazConPantalla){
		Email email = new Email();
		String resultadoenvio = "";
		interfazConPantalla.addAttribute("email", email);
		interfazConPantalla.addAttribute("resultado", resultadoenvio);
		return "email/emailsimple";
	}
	@PostMapping("/email/emailsimple")
	public String postSendMail(@ModelAttribute(name ="email") Email email,Model interfazConPantalla) {
		String resultadoenvio = "";
		System.out.println("emailsimple en el post; " + email.getContent());
		try {
			service.sendAPIMail(email);
			System.out.println("emailsimple enviado");
			resultadoenvio = "Envío correcto";
		} catch (Exception e){
			System.out.println("emailsimple error envío");
			resultadoenvio = "Error envío:" + e;
		}
		interfazConPantalla.addAttribute("resultado", resultadoenvio);
		interfazConPantalla.addAttribute("email", email);
		return "email/emailsimple";
	}

}
