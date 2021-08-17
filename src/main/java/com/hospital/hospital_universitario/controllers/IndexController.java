package com.hospital.hospital_universitario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@GetMapping("/")    
    public String index() {
        return "index";   
    }

    @GetMapping("/paciente")
    public String paciente() {
        return "./paciente/Cadastrar_Paciente";
    }
    @GetMapping("/medico")
    public String medico() {
        return "./medico/Cadastrar_Medico";
    }
    @GetMapping("/exame")
    public String exame() {
        return "./exame/Cadastrar_Exame";
    }
    @GetMapping("/laudo")
    public String laudo() {
        return "./laudo/Cadastrar_Laudo";
    }

    @RequestMapping(value="/cadastrarPaciente", method=RequestMethod.GET)
	public String form() {
		return "index";
	}

}
