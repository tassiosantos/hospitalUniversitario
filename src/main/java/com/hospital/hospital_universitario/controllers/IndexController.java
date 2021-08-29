package com.hospital.hospital_universitario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@GetMapping("/")    
    public String login() {
        return "login";   
    }

    @GetMapping("/index")
    public String index(){
        return login();
    }

    // @GetMapping("/laudo")
    // public String laudo() {
    //     return "./laudo/Cadastrar_Laudo";
    // }
    
    // @GetMapping("/medico")
    // public String medico() {
    //     return "./medico/Cadastrar_Medico";
    // }
    
    // @GetMapping("/paciente")
    // public String paciente() {
    //     return "./paciente/Listar_Paciente";
    // }    

    // @GetMapping("/exame")
    // public String exame() {
    //     return "./exame/Cadastrar_Exame";
    // }
   
    // @RequestMapping(value="/cadastrarPaciente", method=RequestMethod.GET)
	// public String form() {
	// 	return "index";
	// }

}
